package com.jw.demo.app;

public class AppBaseException extends Exception {

    private Integer errCode;


    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
