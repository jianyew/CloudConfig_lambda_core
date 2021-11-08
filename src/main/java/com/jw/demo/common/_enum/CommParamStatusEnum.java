package com.jw.demo.common._enum;

/**
 * @author: YanLan
 * @date: 2019/01/07
 */
public enum CommParamStatusEnum {
    /**
     * 设置该系统模块字段为有效
     */
    VALID(1, "有效"),

    /**
     * 设置该系统模块字段为无效
     */
    INVALID(2, "无效")
    ;

    private int id;
    private String name;

    CommParamStatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
