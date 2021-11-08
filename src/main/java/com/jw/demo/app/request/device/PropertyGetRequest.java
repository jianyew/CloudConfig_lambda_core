package com.jw.demo.app.request.device;

import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.request.Request;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.web.HttpRequestInfo;

import javax.servlet.http.HttpServletRequest;

public class PropertyGetRequest extends Request {

    private Long deviceId; // 设备ID

    @Override
    public Response parse(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        // 校验：设备ID
        this.deviceId = requestInfo.getLongParameter("device_id", 0);
        if (deviceId == Long.valueOf(0)) {
            return new FailResponse(ApiResultEnum.PARAM_ERROR.getId(), "请选择设备");
        }
        return new DefaultResponse();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

}
