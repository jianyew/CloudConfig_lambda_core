package com.jw.demo.app.util.aws.cognito;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult;

import java.util.HashMap;

/**
 * 身份池 工具类
 */
public class IdentityPoolUtil {

    private static AmazonCognitoIdentity identityClient =
            AmazonCognitoIdentityClient.builder().withRegion(Regions.AP_SOUTHEAST_1).build();

    public static void main(String[] args) throws Exception {
        //身份池ID
        String identityPoolId = "ap-southeast-1:b5f91781-ed82-471b-952b-94c42291036e";
        //这个是cognito身份池授权地址，不能改
        String providerName = "cognito-identity.amazonaws.com";
        //这是 token的时长限制 单位是秒
        long tokenDuration = 86400;
        //这个是 身份池  -->身份浏览器 ———> 点击身份ID 进入  ———>  对应 开发人员标识符 的值
        String identifier = "zyj_test1111";//

        //获取cognito 的令牌  "mytest"
        GetOpenIdTokenForDeveloperIdentityResult token = getOpenIdTokenForDeveloperIdentity(identityPoolId, "mytest", identifier, tokenDuration);
        System.err.println("token====="+token.getToken());
        //获取 用户临时凭证(有效时间会返回，但是无法设置)
        System.err.println(getCredentialsForIdentity(token.getIdentityId(), providerName,token.getToken()));
        getOpenIdTokenForDeveloperIdentity(identityPoolId,"mytest","mytest123",60 * 15l);
    }

    /**
     * 获取用户验证令牌
     * @param identityPoolId
     * @param providerName
     * @param identifier
     * @param tokenDuration
     * @return
     * @throws Exception
     */
    public static GetOpenIdTokenForDeveloperIdentityResult getOpenIdTokenForDeveloperIdentity(String identityPoolId,String providerName,String identifier,Long tokenDuration) throws Exception {
        GetOpenIdTokenForDeveloperIdentityRequest request = new GetOpenIdTokenForDeveloperIdentityRequest();
        request.setIdentityPoolId(identityPoolId);
        HashMap<String,String> logins = new HashMap<>();
        logins.put(providerName,identifier);
        request.setLogins(logins);
        request.setTokenDuration(tokenDuration);
        GetOpenIdTokenForDeveloperIdentityResult response = identityClient.getOpenIdTokenForDeveloperIdentity(request);
        String identityId = response.getIdentityId();
        String token = response.getToken();
        System.err.println("identityId:"+identityId);
        System.err.println("token:"+token);
        return response;
    }

    /**
     * 获取身份ID凭证
     * @param identityId 用户身份id
     * @param name 验证商名称
     * @param token 用户令牌
     * @return
     */
    public static GetCredentialsForIdentityResult getCredentialsForIdentity(String identityId,String name,String token){
        GetCredentialsForIdentityRequest getCredentialsForIdentityRequest = new GetCredentialsForIdentityRequest();
        getCredentialsForIdentityRequest.setIdentityId(identityId);
        HashMap<String,String> logins = new HashMap<>();
        logins.put(name,token);
        getCredentialsForIdentityRequest.setLogins(logins);
        System.err.println(identityId+"-"+name+"-"+token);
        return identityClient.getCredentialsForIdentity(getCredentialsForIdentityRequest);
    }

}
