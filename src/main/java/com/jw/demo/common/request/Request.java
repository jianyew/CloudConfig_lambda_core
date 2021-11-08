package com.jw.demo.common.request;

import com.alibaba.fastjson.JSON;
import com.jw.demo.common.response.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 公共参数类
 * @author hongyuhao
 * @version 0.0.1
 */
public abstract class Request implements Serializable {
	
	private static final long serialVersionUID = -8345106786789120936L;

	/**
	 * 解析参数
	 * @param request
	 */
	public abstract Response parse(HttpServletRequest request);
	protected void parseFixedParams(HttpServletRequest request) {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSON.toJSONString(this);
	} 
}
