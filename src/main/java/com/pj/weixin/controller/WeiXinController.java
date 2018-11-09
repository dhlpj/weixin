package com.pj.weixin.controller;

import com.pj.weixin.bean.ReplyTextMessage;
import com.pj.weixin.service.TextMessageService;
import com.pj.weixin.util.CheckUtil;
import com.pj.weixin.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping
public class WeiXinController {
    @Autowired
    private TextMessageService textMessageService;

    /**
     * 验证
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/wx")
    public String checkSignature(String signature, String timestamp,
                                 String nonce, String echostr) {
        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        } else {
            return "";
        }
    }

    /**
     * 发送文字消息
     * @param request
     * @param response
     * @return
     */
    @PostMapping("wx")
    public String replyMessage(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = MessageUtil.xmlToMap(request);
        String result = null;
        if(map==null){
            result = "success";
        }else{
            if(!map.containsKey("MsgType")){
                result = "success";
            }else{
                ReplyTextMessage returnMessage = textMessageService.getReturnMessage(map);
                result = MessageUtil.ObjectToXml(returnMessage);
                System.out.println("正确");
            }
        }
        return result;
    }
}
