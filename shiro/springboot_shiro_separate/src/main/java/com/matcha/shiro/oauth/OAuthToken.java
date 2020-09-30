package com.matcha.shiro.oauth;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 认证token
 */
public class OAuthToken extends UsernamePasswordToken {
    private String token;
    private Long tenantId;

    public OAuthToken(Long tenantId, String token) {
        this.tenantId = tenantId;
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }

    public OAuthToken setToken(String token) {
        this.token = token;
        return this;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public OAuthToken setTenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }
}
