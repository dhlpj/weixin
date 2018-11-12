package com.pj.weixin.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CheckUtil {
    @Value("${weixin.app.info.volidateToken}")
    public String validateToken;

    public boolean checkSignature(String signature,String timestamp, String nonce){
        //1、排序
        String[] arr = {validateToken,timestamp,nonce};
        Arrays.sort(arr);
        //2、拼接字符串
        StringBuilder sb = new StringBuilder();
        for (String string : arr) {
            sb.append(string);
        }
        //3、对拼接字符串进行SHA1加密
        String result = DigestUtils.shaHex(sb.toString());
        //4、与signature对比
        return result.equals(signature);
    }
}
