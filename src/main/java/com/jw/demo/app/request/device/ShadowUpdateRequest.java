package com.jw.demo.app.request.device;

import com.alibaba.fastjson.JSONObject;
import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.request.Request;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.web.HttpRequestInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;




public class ShadowUpdateRequest extends Request {

    private Long deviceId; // 设备ID
    private String data; // 控制内容，JSON形式

    @Override
    public Response parse(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        // 校验：设备ID
        this.deviceId = requestInfo.getLongParameter("deviceId", 0);
        if (deviceId == Long.valueOf(0)) {
            return new FailResponse(ApiResultEnum.PARAM_ERROR.getId(), "请选择设备");
        }
        // 校验：控制内容
        this.data = requestInfo.getParameter("data", "");
        if (StringUtils.isEmpty(data)) {
            return new FailResponse(ApiResultEnum.PARAM_ERROR.getId(), "请输入控制内容");
        }
        try {
            JSONObject.parseObject(data);
        } catch (Exception e) {
            return new FailResponse(ApiResultEnum.PARAM_ERROR.getId(), "请输入合法的控制内容");
        }
        return new DefaultResponse();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
