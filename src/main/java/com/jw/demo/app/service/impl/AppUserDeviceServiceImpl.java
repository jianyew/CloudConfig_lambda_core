package com.jw.demo.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.iot.model.CreatePolicyResult;
import com.jw.demo.app.dao.device.DeviceInfoMapper;
import com.jw.demo.app.request.appdevice.AppBindDeviceRequest;
import com.jw.demo.app.request.appdevice.AppListDeivceRequest;
import com.jw.demo.app.service.AppUserDeviceService;
import com.jw.demo.app.util.aws.cognito.IdentityPoolUtil;
import com.jw.demo.app.util.aws.dynamodb.AppUserDeviceDy;
import com.jw.demo.app.util.aws.policy.IotPolicyUtil;
import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.entity.base.AppUser;
import com.jw.demo.common.entity.dynamodb.AppUserDevice;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.InfoResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.util.CacheKeyConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AppUserDeviceServiceImpl implements AppUserDeviceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDeviceServiceImpl.class);

    @Resource
    private DeviceInfoMapper deviceInfoMapper;

    /**
     * 绑定设备
     *
     * @param appuser
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Response bindAppUserDevice(AppUser appuser, AppBindDeviceRequest request) throws Exception {
        LOGGER.info("用户[{}]->通过MAC绑定设备[{}]",appuser.getId(),request.getMac());
        //开始绑定
        if (StringUtils.isEmpty(request.getMac()) ){// || StringUtil.isEmpty(request.getProductKey())){
            return new FailResponse(ApiResultEnum.PARAM_ERROR);
        }

        //获取用户绑定列表
//        QueryResult queryResult = AppUserDeviceDy.selectUserDevice(appuser.getId());
//        List<AppUserDevice> appUserDeviceList = AppUserDeviceDy.getAppUserDeviceList(queryResult.getItems());
        //建立新的绑定关系
        AppUserDevice putAppDevice = new AppUserDevice();
        putAppDevice.setAppuserId(String.valueOf(appuser.getId()));
        putAppDevice.setMac(request.getMac());
        putAppDevice.setProductId("000");
        putAppDevice.setProductKey("abc");
        putAppDevice.setDeviceNickname(request.getDeviceNickName());
        putAppDevice.setuType("1");
        putAppDevice.setSharer("0");
        putAppDevice.setDeviceId("1");
        long time = new Date().getTime();
        putAppDevice.setUpdateTime(time);
        putAppDevice.setCreateTime(time);
        AppUserDeviceDy.createAppUserDevice(putAppDevice);
//        appUserDeviceList.add(putAppDevice);
        //策略名称
        String policyName = appuser.getName()+"_"+request.getMac();

        //策略内容
        String policy = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Action\":[\"iot:Connect\"],\"Resource\":[\"arn:aws:iot:*:*:client/${cognito-identity.amazonaws.com:sub}\"]},{\"Effect\":\"Allow\",\"Action\":[\"iot:Receive\",\"iot:Subscribe\",\"iot:GetThingShadow\",\"iot:UpdateThingShadow\",\"iot:Publish\"],\"Resource\":[\"*\"]}]}";
        //TODO 生成新的策略
        CreatePolicyResult createPolicyResult = IotPolicyUtil.createPolicy(policyName, policy);

//        //附加策略到用户
//        String identityPoolId = "ap-southeast-1:b5f91781-ed82-471b-952b-94c42291036e";
//        String providerName = "mytest";
//        String identifier =appuser.getAccount();
//        //获取用户身份池令牌
//        GetOpenIdTokenForDeveloperIdentityResult identity = IdentityPoolUtil.getOpenIdTokenForDeveloperIdentity(identityPoolId, providerName, identifier, (long) CacheKeyConstants.REDIS_KEY_EXPIRE_TWO_HOUR);
//        //附加策略到用户
//        IotPolicyUtil.attachPlicy(policyName,identity.getIdentityId());
        return new DefaultResponse();
    }

    /**
     * 用户查询设备
     *
     * @param appUser
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Response listAppUserDevice(AppUser appUser, AppListDeivceRequest request) throws Exception {
        //获取用户绑定列表
        QueryResult queryResult = AppUserDeviceDy.selectUserDevice(appUser.getId());
        List<AppUserDevice> userDevice = AppUserDeviceDy.getAppUserDeviceList(queryResult.getItems());
        InfoResponse<JSONArray> infoResponse = new InfoResponse<>();
        infoResponse.setInfo(JSONArray.parseArray(JSON.toJSONString(userDevice)));
        return infoResponse;
    }

}
