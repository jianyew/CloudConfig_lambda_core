package com.jw.demo.common.response;

import java.util.Collections;
import java.util.List;

/**
 * 列表查询类响应实体
 *
 * @author hongyuhao
 * @version 0.0.1
 */
public class ListResponse<T> extends Response {
    /**
     * uuid
     */
    private static final long serialVersionUID = -4581672836387766530L;

    public ListResponse() {}
    
    public ListResponse(List<T> list) {
		this.list = list;
	}
    
    /**
     * 返回结果列表
     */
    private List<T> list = Collections.emptyList();

    /**
     * 获取返回结果列表
     * @return 返回结果列表
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置返回结果列表
     * @param list 返回结果列表
     */
    public void setList(List<T> list) {
        this.list = list;
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
