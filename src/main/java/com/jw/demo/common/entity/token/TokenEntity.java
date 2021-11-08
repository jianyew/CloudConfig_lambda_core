package com.jw.demo.common.entity.token;

import com.jw.demo.common.entity.base.AppUser;

import java.io.Serializable;

public class TokenEntity implements Serializable {
    //token
    private String token;
    //刷新token
    private String refreshToken;
    //有效时间单位秒
    private int expiresIn;
    //App用户信息
    private AppUser appUser;
    //用户session
    private UserProofEntity session;

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public UserProofEntity getSession() {
        return session;
    }

    public void setSession(UserProofEntity session) {
        this.session = session;
    }
}
