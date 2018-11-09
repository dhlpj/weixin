package com.pj.weixin.service;

import com.pj.weixin.bean.ReplyTextMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author Jack
 * @create 2018-11-08 17:58
 */
@Service
public class TextMessageService {
    public ReplyTextMessage getReturnMessage(Map<String,String> map){
        ReplyTextMessage textMessage = new ReplyTextMessage();
        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");
        textMessage.setFromUserName(ToUserName);
        textMessage.setToUserName(FromUserName);
        textMessage.setMsgType(MsgType);
        textMessage.setContent("您输入的是："+Content);
        System.out.println(Content);
        textMessage.setCreateTime(new Date().getTime());
        return textMessage;
    }
}
