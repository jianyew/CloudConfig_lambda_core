package com.jw.demo.common.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jw.demo.common._enum.ApiResultEnum;

import java.io.Serializable;

/**
 * 公共响应类
 *
 * @author hongyuhao
 * @version 0.0.1
 */
public abstract class Response implements Serializable {
	/**
	 * uuid
	 */
	private static final long serialVersionUID = 2430928175247208189L;

	/**
	 * 默认返回结果
	 */
	protected String tip = ApiResultEnum.SUCCESS.getName();
	/**
	 * 默认状态码
	 */
	protected int code = ApiResultEnum.SUCCESS.getId();

	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * 返回状态码
	 *
	 * @return 状态码
	 *
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * 返回状态码
	 *
	 * @return 状态码
	 *
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 设置请求状态码
	 *
	 * @param code 请求状态码
	 *
	 */
	public void setCode(int code) {
		this.code = code;
	}


	/**
	 * 设置请求状态码
	 *
	 * @return 响应体json字符串
	 *
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
	}
}
