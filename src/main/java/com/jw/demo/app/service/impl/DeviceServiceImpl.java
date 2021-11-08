package com.jw.demo.app.service.impl;

import java.util.*;

import javax.annotation.Resource;

import com.amazonaws.regions.Regions;
import com.jw.demo.app.dao.device.DeviceInfoMapper;
import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common._enum.AppStatusEnum;
import com.jw.demo.common._enum.DeletedEnum;
import com.jw.demo.common.entity.device.DeviceInfo;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.InfoResponse;
import com.jw.demo.common.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jw.demo.app.request.device.CertificateGetRequest;
import com.jw.demo.app.request.device.PropertyGetRequest;
import com.jw.demo.app.request.device.ShadowUpdateRequest;
import com.jw.demo.app.service.DeviceService;
import com.jw.demo.app.util.aws.iot.IotUtil;
import com.jw.demo.app.util.aws.iot.ShadowUtil;
import com.jw.demo.app.util.aws.s3.S3Util;
import com.jw.demo.common.util.SnowflakeIdWorker;
import org.springframework.util.CollectionUtils;

@Service
public class DeviceServiceImpl implements DeviceService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private DeviceInfoMapper deviceInfoMapper;


    @SuppressWarnings("unchecked")
    @Override
    public Response certificateGet(CertificateGetRequest request) throws Exception {
        String productKey = "999999";
        String mac = request.getMac();

//        String accessKey = "awsConfig.getAccessKey()";
//        String null = "awsConfig.getnull()";
//        String region =" awsConfig.getRegion()";
        String region = Regions.AP_SOUTHEAST_1.getName();

        // 1. 生成事物
        InfoResponse<JSONObject> createThingResponse = (InfoResponse<JSONObject>) IotUtil.getInstance()
                .createThing(region, mac);
        if (ApiResultEnum.SUCCESS.getId() != createThingResponse.getCode()) {
            log.error("certificateGet -> 创建事物失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }

        // 2. 生成证书
        InfoResponse<JSONObject> createKeysAndCertificateResponse = (InfoResponse<JSONObject>) IotUtil.getInstance()
                .createKeysAndCertificate(region);
        if (ApiResultEnum.SUCCESS.getId() != createKeysAndCertificateResponse.getCode()) {
            log.error("certificateGet -> 创建证书失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }
        String certificateArn = createKeysAndCertificateResponse.getInfo().getString("certificateArn");
        String certificatePem = createKeysAndCertificateResponse.getInfo().getString("certificatePem");
        JSONObject keyPair = createKeysAndCertificateResponse.getInfo().getJSONObject("keyPair");
        String privateKey = keyPair.getString("privateKey");

        // 3. 生成策略
        Response getPolicyResponse = IotUtil.getInstance().getPolicy( region, mac);
        if (ApiResultEnum.SUCCESS.getId() != getPolicyResponse.getCode()) {
            String policyDocument = IotUtil.generatePolicyDocument(productKey, mac);
            InfoResponse<JSONObject> createPolicyResponse = (InfoResponse<JSONObject>) IotUtil.getInstance()
                    .createPolicy(region, mac, policyDocument);
            if (ApiResultEnum.SUCCESS.getId() != createPolicyResponse.getCode()) {
                log.error("certificateGet -> 创建策略失败");
                return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
            }
        }

        // 4. 附加证书策略
        Response attachPrincipalPolicyResponse = IotUtil.getInstance().attachPrincipalPolicy(region, mac, certificateArn);
        if (ApiResultEnum.SUCCESS.getId() != attachPrincipalPolicyResponse.getCode()) {
            log.error("certificateGet -> 附加证书策略失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }

        // 5. 附加事物证书
        Response attachThingPrincipalResponse = IotUtil.getInstance().attachThingPrincipal(region, certificateArn, mac);
        if (ApiResultEnum.SUCCESS.getId() != attachThingPrincipalResponse.getCode()) {
            log.error("certificateGet -> 附加事物证书失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }

        // 6. 上传设备证书至S3
        String s3CertificatePemKey = mac + "_certificatePem";
        Response uploadCertificatePemResponse = S3Util.getInstance().uploadObject( region,
                "cconfig-certificate", s3CertificatePemKey, certificatePem);
        if (ApiResultEnum.SUCCESS.getId() != uploadCertificatePemResponse.getCode()) {
            log.error("certificateGet -> 上传设备证书PEM失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }
        String s3PrivateKeyKey = mac + "_privateKey";
        Response uploadPrivateKeyResponse = S3Util.getInstance().uploadObject(region,
                "cconfig-certificate", s3PrivateKeyKey, privateKey);
        if (ApiResultEnum.SUCCESS.getId() != uploadPrivateKeyResponse.getCode()) {
            log.error("certificateGet -> 上传设备证书KEY失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }

        // 7. 生成设备证书预签名URL
        InfoResponse<String> generateCertificatePemPresignedUrlResponse = (InfoResponse<String>) S3Util.getInstance()
                .generatePresignedUrl( region, "cconfig-certificate", s3CertificatePemKey);
        if (ApiResultEnum.SUCCESS.getId() != generateCertificatePemPresignedUrlResponse.getCode()) {
            log.error("certificateGet -> 生成设备证书PEM的预签名地址失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }
        String certificatePemUrl = generateCertificatePemPresignedUrlResponse.getInfo();

        InfoResponse<String> generatePrivateKeyPresignedUrlResponse = (InfoResponse<String>) S3Util.getInstance()
                .generatePresignedUrl(region, "cconfig-certificate", s3PrivateKeyKey);
        if (ApiResultEnum.SUCCESS.getId() != generatePrivateKeyPresignedUrlResponse.getCode()) {
            log.error("certificateGet -> 生成设备证书KEY的预签名地址失败");
            return new FailResponse(ApiResultEnum.DEVICE_CERTIFICATE_GET_FAIL);
        }
        String privateKeyUrl = generatePrivateKeyPresignedUrlResponse.getInfo();

        // 8. 添加设备
        Date nowTime = new Date();
        DeviceInfo deviceInfo;
        Map<String, Object> paramsDI = new HashMap<String, Object>();
        paramsDI.put("eqProductKey", privateKey);
        paramsDI.put("eqMac", mac);
        paramsDI.put("eqDeleted", DeletedEnum.F.getId());
        List<DeviceInfo> deviceInfos = deviceInfoMapper.selectByMap(paramsDI);
        if (CollectionUtils.isEmpty(deviceInfos)) {
            deviceInfo = new DeviceInfo();
            deviceInfo.setId(SnowflakeIdWorker.getId());
            deviceInfo.setName(mac);
            deviceInfo.setMac(mac);
//            deviceInfo.setProductId(productInfo.getId());
//            deviceInfo.setProductName(productInfo.getName());
//            deviceInfo.setMerchantId(productInfo.getMerchantId());
//            deviceInfo.setMerchantName(productInfo.getMerchantName());
            deviceInfo.setStatus(AppStatusEnum.NORMAL.getId());
            deviceInfo.setCreateTime(nowTime);
            deviceInfo.setUpdateTime(nowTime);
            deviceInfo.setDeleted(DeletedEnum.F.getId());
//            deviceInfoMapper.insertSelective(deviceInfo);
            System.out.println(deviceInfo);
        }

        JSONObject info = new JSONObject();
        info.put("thingName", mac);
        info.put("privateKey", privateKeyUrl);
        info.put("certificatePem", certificatePemUrl);
        info.put("certificateArn", certificateArn);
        info.put("region", region);
        info.put("regionId", region);
        info.put("domain", "a3r68s0rrta0ju-ats.iot.us-west-2.amazonaws.com");
        return new InfoResponse<>(info);
    }

    @Override
    public Response propertyGet(PropertyGetRequest request) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response updateShadow(ShadowUpdateRequest request) throws Exception {
        String accessKey = "awsConfig.getAccessKey()";
        String secretKey =" awsConfig.getSecretKey()";
        String region =" awsConfig.getRegion()";
        Response updateThingShadowResponse = ShadowUtil.getInstance().updateThingShadow(accessKey, secretKey, region,
                "mac", request.getData());
        if (ApiResultEnum.SUCCESS.getId() != updateThingShadowResponse.getCode()) {
            log.error("updateShadow -> 更新事物影子失败");
            return new FailResponse(ApiResultEnum.DEVICE_SHADOW_UPDATE_FAIL);
        }
        return new DefaultResponse();
    }
}
