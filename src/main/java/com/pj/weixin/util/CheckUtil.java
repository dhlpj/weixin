package com.pj.weixin.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class CheckUtil {
    public static final String TOKEN = "dhlpj";

    public static boolean checkSignature(String signature,String timestamp, String nonce){
        //1、排序
        String[] arr = {TOKEN,timestamp,nonce};
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
