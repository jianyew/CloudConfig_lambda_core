package com.jw.demo.app.request.device;

import com.jw.demo.common._enum.ApiResultEnum;
import com.jw.demo.common.request.Request;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.FailResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.web.HttpRequestInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class CertificateGetRequest extends Request {

    private String productKey; // 产品PK
    private String mac; // 设备MAC

    @Override
    public Response parse(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        // 校验：产品PK
        this.productKey = requestInfo.getParameter("productKey", "");
        if (StringUtils.isEmpty(productKey)) {
            return new FailResponse(ApiResultEnum.PARAM_ERROR.getId(), "请输入产品PK");
        }
        // 校验：设备MAC
        this.mac = requestInfo.getParameter("mac", "");
        if (StringUtils.isEmpty(mac)) {
            return new FailResponse(ApiResultEnum.PARAM_ERROR.getId(), "请输入设备MAC");
        }
        this.mac = mac.replaceAll("-", "").replaceAll(":", "").toUpperCase();
        return new DefaultResponse();
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

}
