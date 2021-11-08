package com.jw.demo.common._enum;

import java.util.HashMap;
import java.util.Map;

public enum PolicyEnum {

    /**
     * IAM策略
     */
    IAM(1, "IAM策略"),
    /**
     * IOT策略
     */
    IOT(2, "IOT策略");

    private int id;
    private String name;

    PolicyEnum(int id, String name) {
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

    public static Map<Integer, String> listAllTypes() {
        Map<Integer, String> typesMap = new HashMap<Integer, String>();
        PolicyEnum[] enums = values();
        for (PolicyEnum object : enums) {
            typesMap.put(object.getId(), object.getName());
        }
        return typesMap;
    }
}
