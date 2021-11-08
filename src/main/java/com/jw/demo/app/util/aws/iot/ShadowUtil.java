package com.jw.demo.app.util.aws.iot;

import java.nio.ByteBuffer;

import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.Response;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.iotdata.AWSIotData;
import com.amazonaws.services.iotdata.AWSIotDataClientBuilder;
import com.amazonaws.services.iotdata.model.UpdateThingShadowRequest;
import com.amazonaws.services.iotdata.model.UpdateThingShadowResult;

public class ShadowUtil {
    private Logger log = LoggerFactory.getLogger(getClass());

    public static ShadowUtil getInstance() {
        return new ShadowUtil();
    }

    /**
     * 更新设备影子，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/developerguide/device-shadow-mqtt.html#update-pub-sub-topic
     * 
     * @param accessKey 亚马逊接口凭证
     * @param secretKey 亚马逊接口凭证
     * @param region    亚马逊区域
     * @param thingName 事物名称
     * @param payload   内容，格式JSON。{"state":{"desired":{"属性":"值",...}}}
     * @return
     */
    public Response updateThingShadow(String accessKey, String secretKey, String region, String thingName,
                                      ByteBuffer payload) {
        try {
            BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
            AWSIotData iotDataClient = AWSIotDataClientBuilder.standard().withRegion(region)
                    .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

            UpdateThingShadowRequest request = new UpdateThingShadowRequest();
            request.setThingName(thingName);
            request.setPayload(payload);

            UpdateThingShadowResult result = iotDataClient.updateThingShadow(request);
            if (HttpStatus.SC_OK != result.getSdkHttpMetadata().getHttpStatusCode()) {
                return new FailResponse();
            }
        } catch (Exception e) {
            log.error("ShadowUtil.updateThingShadow", e);
            return new FailResponse();
        }
        return new DefaultResponse();
    }

    /**
     * 更新设备影子，参考文档：https://docs.aws.amazon.com/zh_cn/iot/latest/developerguide/device-shadow-mqtt.html#update-pub-sub-topic
     * 
     * @param accessKey 亚马逊接口凭证
     * @param secretKey 亚马逊接口凭证
     * @param region    亚马逊区域
     * @param thingName 事物名称
     * @param payload   内容，格式JSON。{"属性":"值",...}
     * @return
     */
    public Response updateThingShadow(String accessKey, String secretKey, String region, String thingName,
            String data) {
        JSONObject dataJson = JSONObject.parseObject(data);
        JSONObject stateJson = new JSONObject();
        stateJson.put("desired", dataJson);
        JSONObject payloadJson = new JSONObject();
        payloadJson.put("state", stateJson);
        ByteBuffer payload = ByteBuffer.wrap(payloadJson.toJSONString().getBytes());
        return updateThingShadow(accessKey, secretKey, region, thingName, payload);
    }


}
