package com.jw.demo.common.response;

import com.jw.demo.common._enum.ApiResultEnum;

/**
 * 默认相应失败实体
 * 
 * @author houlong
 * @version 0.0.1
 */
public class FailResponse extends Response {

    private static final long serialVersionUID = -1446790741731428665L;

    public FailResponse() {
        this.code = ApiResultEnum.FAIL.getId();
        this.tip = ApiResultEnum.FAIL.getName();
    }

    public FailResponse(String tip) {
        this.code = ApiResultEnum.FAIL.getId();
        this.tip = tip;
    }

    public FailResponse(int code, String tip) {
        this.code = code;
        this.tip = tip;
    }

    public FailResponse(ApiResultEnum apiResultEnum) {
        this.code = apiResultEnum.getId();
        this.tip = apiResultEnum.getName();
    }

    public FailResponse(ApiResultEnum apiResultEnum, String tip) {
        this.code = apiResultEnum.getId();
        this.tip = tip;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
