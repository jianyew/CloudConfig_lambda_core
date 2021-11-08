package com.jw.demo.common.entity.token;

import java.io.Serializable;

/**
 * 用户权限凭证
 */
public class UserProofEntity implements Serializable {
    private String accessKeyId;
    private String expiration;
    private String secretKey;
    private String sessionToken;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
