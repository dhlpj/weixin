package com.pj.weixin.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Jack
 * @create 2018-11-09 17:51
 */
public class WeiXinUtil {
    @Value("${weixin.app.info.accessTokenUrl}")
    private String accessTokenUrl;

}
