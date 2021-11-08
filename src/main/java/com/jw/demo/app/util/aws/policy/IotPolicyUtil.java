package com.jw.demo.app.util.aws.policy;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.AWSIotClient;
import com.amazonaws.services.iot.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Iot 策略工具类
 */
public class IotPolicyUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IotPolicyUtil.class);
    private static final AWSIot awsIot = AWSIotClient.builder().withRegion(Regions.AP_SOUTHEAST_1).build();

    /**
     * 获取策略信息 (非策略内容)
     * @param policyName 策略名称
     * @return
     * @throws Exception
     */
    public static GetPolicyResult getPolicy(String policyName)throws Exception{

        GetPolicyRequest getPolicyRequest = new GetPolicyRequest();
        getPolicyRequest.setPolicyName(policyName);

        return awsIot.getPolicy(getPolicyRequest);
    }

    /**
     * 创建策略
     * @param policyName 策略名称
     * @param policyDocument 策略内容
     * @return
     * @throws Exception
     */
    public static CreatePolicyResult createPolicy(String policyName,String policyDocument)throws Exception{
        CreatePolicyRequest createPolicyRequest = new CreatePolicyRequest();
        createPolicyRequest.setPolicyName(policyName);
        createPolicyRequest.setPolicyDocument(policyDocument);
        System.out.println(policyDocument);
        return awsIot.createPolicy(createPolicyRequest);
    }

    /**
     * 更新策略并设置为默认版本
     * @param policyName 策略名称
     * @param policyDocument 策略内容
     * @return
     * @throws Exception
     */
    public static CreatePolicyVersionResult createPolicyVersion(String policyName,String policyDocument)throws Exception{
        CreatePolicyVersionRequest createPolicyVersionRequest = new CreatePolicyVersionRequest();
        createPolicyVersionRequest.setPolicyName(policyName);
        createPolicyVersionRequest.setPolicyDocument(policyDocument);
        createPolicyVersionRequest.setSetAsDefault(true);
        return awsIot.createPolicyVersion(createPolicyVersionRequest);

    }

    /**
     * 删除策略版本
     * @param policyName 策略名称
     * @param policyVersionId 策略版本
     * @return
     * @throws Exception
     */
    public static boolean deletePolicyversion(String policyName,String policyVersionId)throws  Exception{
        DeletePolicyVersionRequest deletePolicyVersionRequest = new DeletePolicyVersionRequest();
        deletePolicyVersionRequest.setPolicyName(policyName);
        deletePolicyVersionRequest.setPolicyVersionId(policyVersionId);
        DeletePolicyVersionResult deletePolicyVersionResult = awsIot.deletePolicyVersion(deletePolicyVersionRequest);
        if (deletePolicyVersionResult.getSdkHttpMetadata().getHttpStatusCode() == 200){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 删除策略
     * @param policyName 策略名称
     * @return
     * @throws Exception
     */
    public static boolean deletePolicy(String policyName)throws Exception{
        DeletePolicyRequest deletePolicyRequest = new DeletePolicyRequest();
        deletePolicyRequest.setPolicyName(policyName);
        DeletePolicyResult result = awsIot.deletePolicy(deletePolicyRequest);
        if (result.getSdkHttpMetadata().getHttpStatusCode() == 200){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 附加策略
     * @param policyName 策略名称
     * @param target 目标身份
     * @return
     */
    public static boolean attachPlicy(String policyName,String target){
        AttachPolicyRequest attachPolicyRequest = new AttachPolicyRequest();
        attachPolicyRequest.setPolicyName(policyName);
        attachPolicyRequest.setTarget(target);
        AttachPolicyResult result = awsIot.attachPolicy(attachPolicyRequest);
        if (result.getSdkHttpMetadata().getHttpStatusCode() == 200){
            return true;
        }else{
            return false;
        }
    }

}
