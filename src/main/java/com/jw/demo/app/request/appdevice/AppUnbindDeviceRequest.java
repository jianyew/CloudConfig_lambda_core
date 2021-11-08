package com.jw.demo.app.request.appdevice;

import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.request.Request;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.web.HttpRequestInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class AppUnbindDeviceRequest extends Request {
    private Long deviceId;
    /**
     * 解析参数
     *
     * @param request
     */
    @Override
    public Response parse(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        String deviceId = requestInfo.getParameter("deviceId", null);
        if (StringUtils.isEmpty(deviceId)){
            return new FailResponse(ApiResultEnum.PARAM_ERROR);
        }
        this.deviceId = Long.valueOf(deviceId);
        return new DefaultResponse();
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() {
        return deviceId;
    }
}
