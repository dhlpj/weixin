package com.pj.weixin.bean;

/**
 * @author Jack
 * @create 2018-11-09 16:33
 */
public class AccessToken {
    private String access_token;//获取到的令牌
    private int expires_in;//过期时间，单位s

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
