package com.pj.weixin.util;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack
 * @create 2018-11-12 16:54
 */
@Component
public class TraslateUtil {
    @Value("${baidu.traslate.baseUrl}")
    private String baseUrl;
    @Value("${baidu.traslate.appid}")
    private String appid;
    @Value("${baidu.traslate.securityKey}")
    private String securityKey;

    private static final Logger logger = LoggerFactory.getLogger(TraslateUtil.class);

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        JSONObject jsonObject = HttpClientUtil.doPost(baseUrl, JSONObject.fromObject(params).toString());
        if(jsonObject.containsKey("error_code")){
            logger.info("错误码:"+jsonObject.getString("error_code"));
            return "服务器出现问题，请稍后再试！";
        }
        return jsonObject.getString("trans_result");
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", DigestUtils.md5Hex(src));

        return params;
    }
}
