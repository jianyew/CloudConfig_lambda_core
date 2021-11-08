package com.jw.demo.app.request.appdevice;

import com.jw.demo.common.request.Request;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.web.HttpRequestInfo;

import javax.servlet.http.HttpServletRequest;


public class AppBindDeviceRequest extends Request {

    private Long deviceId;
    private String mac;
    private String deviceNickName;
    //private String productKey;

    /**
     * 解析参数
     *
     * @param request
     */
    @Override
    public Response parse(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        this.deviceId = Long.valueOf(requestInfo.getParameter("deviceId","1000"));

        this.mac = requestInfo.getParameter("mac","");
        this.deviceNickName = requestInfo.getParameter("deviceNickName","");
      //  this.productKey =requestInfo.getParameter("productKey","pk001");
        return new DefaultResponse();
    }

    public String getMac() {
        return mac;
    }

    public String getDeviceNickName() {
        return deviceNickName;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setDeviceNickName(String deviceNickName) {
        this.deviceNickName = deviceNickName;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

//   // public String getProductKey() {
//        return productKey;
//    }

//    public void setProductKey(String productKey) {
//        this.productKey = productKey;
//    }
}
