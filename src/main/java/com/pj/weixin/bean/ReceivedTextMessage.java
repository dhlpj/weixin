package com.pj.weixin.bean;

/**
 * @author Jack
 * @create 2018-11-08 16:34
 */
public class ReceivedTextMessage extends BaseMessage {
    private String Content;//内容
    private String MsgId;//消息id

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
