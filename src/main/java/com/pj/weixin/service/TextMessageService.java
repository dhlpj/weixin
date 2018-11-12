package com.pj.weixin.service;

import com.pj.weixin.bean.ReplyTextMessage;
import com.pj.weixin.util.TraslateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author Jack
 * @create 2018-11-08 17:58
 */
@Service
public class TextMessageService {
    @Autowired
    private TraslateUtil traslateUtil;

    private final String from = "auto";
    private final String to = "en";

    public ReplyTextMessage getReturnMessage(Map<String,String> map){
        ReplyTextMessage textMessage = new ReplyTextMessage();
        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");
        textMessage.setFromUserName(ToUserName);
        textMessage.setToUserName(FromUserName);
        textMessage.setMsgType(MsgType);
        String translateResult = traslateUtil.getTransResult(Content, from, to);
        textMessage.setContent(translateResult);
        textMessage.setCreateTime(new Date().getTime());
        return textMessage;
    }
}
