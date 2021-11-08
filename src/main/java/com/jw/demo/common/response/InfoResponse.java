package com.jw.demo.common.response;

/**
 * 信息获取类响应实体
 *
 * @author hongyuhao
 * @version 0.0.1
 */
public class InfoResponse<T> extends Response {
    /**
     * uuid
     */
    private static final long serialVersionUID = 5424773206360048131L;

    public InfoResponse() {}
    
    public InfoResponse(T info) {
		this.info = info;
	}
    
    /**
     * 响应实体
     */
    private T info;

    /**
     * 获取响应实体
     * @return 响应实体
     */
    public T getInfo() {
        return info;
    }

    /**
     *设置响应实体
     * @param info 响应实体
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * 重写tostring
     * @return 相应结果json字符串
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
