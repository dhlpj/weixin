package com.pj.weixin.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Jack
 * @create 2018-11-09 17:54
 */
@ConfigurationProperties(prefix = "weixin.app.info")
public class AccessTokenForm {
    @Value("client_credential")
    private String grant_type;
    private String appid;
    private String secret;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
