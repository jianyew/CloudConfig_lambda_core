package com.jw.demo.common.entity.policy;

import java.util.List;

public class PolicyDivEntity {
    private String Effect;
    private List<String> Action;
    private List<String> Resource;

    public String getEffect() {
        return Effect;
    }

    public List<String> getAction() {
        return Action;
    }

    public void setEffect(String effect) {
        Effect = effect;
    }

    public void setAction(List<String> action) {
        Action = action;
    }

    public List<String> getResource() {
        return Resource;
    }

    public void setResource(List<String> resource) {
        Resource = resource;
    }

    @Override
    public String toString() {
        return "{" +
                "\"Effect\":\"" + Effect + '\"' +
                ",\"Action\":" + Action +
                ",\"Resource\":" + Resource +
                '}';
    }
}
