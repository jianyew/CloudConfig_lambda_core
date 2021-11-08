package com.jw.demo.app.util.aws.iot;

import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.InfoResponse;
import com.jw.demo.common.response.Response;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.AWSIotClientBuilder;
import com.amazonaws.services.iot.model.AttachPrincipalPolicyRequest;
import com.amazonaws.services.iot.model.AttachPrincipalPolicyResult;
import com.amazonaws.services.iot.model.AttachThingPrincipalRequest;
import com.amazonaws.services.iot.model.AttachThingPrincipalResult;
import com.amazonaws.services.iot.model.CreateKeysAndCertificateRequest;
import com.amazonaws.services.iot.model.CreateKeysAndCertificateResult;
import com.amazonaws.services.iot.model.CreatePolicyRequest;
import com.amazonaws.services.iot.model.CreatePolicyResult;
import com.amazonaws.services.iot.model.CreatePolicyVersionRequest;
import com.amazonaws.services.iot.model.CreatePolicyVersionResult;
import com.amazonaws.services.iot.model.CreateThingRequest;
import com.amazonaws.services.iot.model.CreateThingResult;
import com.amazonaws.services.iot.model.GetPolicyRequest;
import com.amazonaws.services.iot.model.GetPolicyResult;

public class IotUtil {
    private Logger log = LoggerFactory.getLogger(getClass());

    public static IotUtil getInstance() {
        return new IotUtil();
    }

    /**
     * 创建事物，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_CreateThing.html
     * 
     * @param accessKey 亚马逊接口凭证
     * @param secretKey 亚马逊接口凭证
     * @param region    亚马逊区域
     * @param thingName 事物名称
     * @return
     */
    public Response createThing( String region, String thingName) {
        CreateThingResult result;
        try {

            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region).build();
            CreateThingRequest request = new CreateThingRequest();
            request.setThingName(thingName);
            result = iotClient.createThing(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.createThing", e);
            return new FailResponse();
        }
        JSONObject info = new JSONObject();
        info.put("thingName", result.getThingName());
        info.put("thingArn", result.getThingArn());
        info.put("thingId", result.getThingId());
        return new InfoResponse<>(info);
    }

    /**
     * 创建证书，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_CreateKeysAndCertificate.html
     * 
     * @param accessKey 亚马逊接口凭证
     * @param secretKey 亚马逊接口凭证
     * @param region    亚马逊区域
     * @return
     */
    public Response createKeysAndCertificate(String region) {
        CreateKeysAndCertificateResult result;
        try {
            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region).build();
            CreateKeysAndCertificateRequest request = new CreateKeysAndCertificateRequest();
            request.setSetAsActive(true);
            result = iotClient.createKeysAndCertificate(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.createKeysAndCertificate", e);
            return new FailResponse();
        }
        JSONObject info = new JSONObject();
        info.put("certificateArn", result.getCertificateArn());
        info.put("certificateId", result.getCertificateId());
        info.put("certificatePem", result.getCertificatePem());
        info.put("keyPair", result.getKeyPair());
        return new InfoResponse<>(info);
    }

    /**
     * 附加事物证书，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_AttachThingPrincipal.html
     * 
     * @param accessKey 亚马逊接口凭证
     * @param secretKey 亚马逊接口凭证
     * @param region    亚马逊区域
     * @param principal 证书ARN / Cognito ID
     * @param thingName 事物名称
     * @return
     */
    public Response attachThingPrincipal(String region, String principal,
            String thingName) {
        try {
            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region).build();
            AttachThingPrincipalRequest request = new AttachThingPrincipalRequest();
            request.setThingName(thingName);
            request.setPrincipal(principal);
            AttachThingPrincipalResult result = iotClient.attachThingPrincipal(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.attachThingPrincipal", e);
            return new FailResponse();
        }
        return new DefaultResponse();
    }

    /**
     * 获取策略，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_GetPolicy.html
     * 
     * @param accessKey  亚马逊接口凭证
     * @param secretKey  亚马逊接口凭证
     * @param region     亚马逊区域
     * @param policyName 策略名称
     * @return
     */
    public Response getPolicy(String region, String policyName) {
        try {
            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region).build();
            GetPolicyRequest request = new GetPolicyRequest();
            request.setPolicyName(policyName);
            GetPolicyResult result = iotClient.getPolicy(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.getPolicy", e);
            return new FailResponse();
        }
        return new DefaultResponse();
    }
    
    /**
     * 创建策略，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_CreatePolicy.html
     * 
     * @param accessKey      亚马逊接口凭证
     * @param secretKey      亚马逊接口凭证
     * @param region         亚马逊区域
     * @param policyName     策略名称
     * @param policyDocument 策略文件
     * @return
     */
    public Response createPolicy( String region, String policyName,
            String policyDocument) {
        CreatePolicyResult result;
        try {
            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region).build();
            CreatePolicyRequest request = new CreatePolicyRequest();
            request.setPolicyName(policyName);
            request.setPolicyDocument(policyDocument);
            result = iotClient.createPolicy(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.createPolicy", e);
            return new FailResponse();
        }
        JSONObject info = new JSONObject();
        info.put("policyArn", result.getPolicyArn());
        info.put("policyDocument", result.getPolicyDocument());
        info.put("policyName", result.getPolicyName());
        info.put("policyVersionId", result.getPolicyVersionId());
        return new InfoResponse<>(info);
    }
    
    /**
     * 创建策略版本，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_CreatePolicyVersion.html
     * 
     * @param accessKey      亚马逊接口凭证
     * @param secretKey      亚马逊接口凭证
     * @param region         亚马逊区域
     * @param policyName     策略名称
     * @param policyDocument 策略文件
     * @return
     */
    public Response CreatePolicyVersion(String region, String policyName, String policyDocument) {
        CreatePolicyVersionResult result;
        try {
            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region)
                    .build();
            CreatePolicyVersionRequest request = new CreatePolicyVersionRequest();
            request.setPolicyName(policyName);
            request.setPolicyDocument(policyDocument);
            request.setSetAsDefault(true);

            result = iotClient.createPolicyVersion(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.CreatePolicyVersion", e);
            return new FailResponse();
        }
        JSONObject info = new JSONObject();
        info.put("policyArn", result.getPolicyArn());
        info.put("policyDocument", result.getPolicyDocument());
        info.put("policyVersionId", result.getPolicyVersionId());
        return new InfoResponse<>(info);
    }
    
    /**
     * 附加证书策略，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/apireference/API_AttachPrincipalPolicy.html
     * 
     * @param accessKey  亚马逊接口凭证
     * @param secretKey  亚马逊接口凭证
     * @param region     亚马逊区域
     * @param policyName 策略名称
     * @param principal  证书ARN / Cognito ID
     * @return
     */
    public Response attachPrincipalPolicy(String region, String policyName,
            String principal) {
        AttachPrincipalPolicyResult result;
        try {
            AWSIot iotClient = AWSIotClientBuilder.standard().withRegion(region).build();

            AttachPrincipalPolicyRequest request = new AttachPrincipalPolicyRequest();
            request.setPolicyName(policyName);
            request.setPrincipal(principal);

            result = iotClient.attachPrincipalPolicy(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("IotUtil.attachPrincipalPolicy", e);
            return new FailResponse();
        }
        return new DefaultResponse();
    }

    /**
     * 生成策略文档
     * 
     * @param productKey 产品密钥
     * @param thingName  事物名称
     * @return
     */
    public static String generatePolicyDocument(String productKey,String thingName) {
        String policyDocument =
                "{" +
                "  \"Version\": \"2012-10-17\"," +
                "  \"Statement\": [" +
                "    {" +
                "      \"Effect\": \"Allow\"," +
                "      \"Action\": [" +
                "        \"iot:Connect\"" +
                "      ]," +
                "      \"Resource\": [" +
                "        \"arn:aws:iot:ap-southeast-1:964479626419:client/thingName\"" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"Effect\": \"Allow\"," +
                "      \"Action\": [" +
                "        \"iot:Publish\"," +
                "        \"iot:Receive\"" +
                "      ]," +
                "      \"Resource\": [" +
                "        \"arn:aws:iot:ap-southeast-1:964479626419:topic/$aws/things/thingName/shadow/*\"," +
                "        \"arn:aws:iot:ap-southeast-1:964479626419:topic/productKey/thingName/*\"" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"Effect\": \"Allow\"," +
                "      \"Action\": [" +
                "        \"iot:Subscribe\"" +
                "      ]," +
                "      \"Resource\": [" +
                "        \"arn:aws:iot:ap-southeast-1:964479626419:topicfilter/$aws/things/thingName/shadow/*\"," +
                "        \"arn:aws:iot:ap-southeast-1:964479626419:topicfilter/productKey/thingName/*\"" +
                "      ]" +
                "    }" +
                "  ]" +
                "}";
        return policyDocument.replaceAll("productKey", productKey).replaceAll("thingName", thingName);
    }

    public static void main(String[] args) {

        String region = "ap-southeast-1";
        String policyName = "A0000011";
        IotUtil.getInstance().CreatePolicyVersion(region, policyName, generatePolicyDocument("A", "B"));
    }
    
}
