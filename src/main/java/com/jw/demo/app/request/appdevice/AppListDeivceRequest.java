package com.jw.demo.app.request.appdevice;

import com.jw.demo.common.request.Request;
import com.jw.demo.common.response.DefaultResponse;
import com.jw.demo.common.response.Response;
import com.jw.demo.common.web.HttpRequestInfo;

import javax.servlet.http.HttpServletRequest;

public class AppListDeivceRequest extends Request {

    private String productId;
    private Integer type;
    private String nickName;

    /**
     * 解析参数
     *
     * @param request
     */
    @Override
    public Response parse(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        this.nickName = requestInfo.getParameter("nickName","");
        this.productId = requestInfo.getParameter("productId","");
//        this.type = Integer.valueOf(requestInfo.getParameter("type",""));
        return new DefaultResponse();
    }

    public String getProductId() {
        return productId;
    }

    public Integer getType() {
        return type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
