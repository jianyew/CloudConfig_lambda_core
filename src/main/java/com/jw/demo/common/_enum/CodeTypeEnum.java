package com.jw.demo.common._enum;

import java.util.HashMap;
import java.util.Map;

public enum CodeTypeEnum {

    /**
     * 注册
     */
    REGISTER("REGISTER", "注册"),
    /**
     * 登录
     */
    LOGIN("LOGIN", "登录"),
    /**
     * 重置密码
     */
    PWD_RESET("PWD_RESET", "重置密码");

    private String key;
    private String name;

    CodeTypeEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Map<String, String> listAllTypes() {
        Map<String, String> typesMap = new HashMap<String, String>();
        CodeTypeEnum[] enums = values();
        for (CodeTypeEnum object : enums) {
            typesMap.put(object.getKey(), object.getName());
        }
        return typesMap;
    }

}
