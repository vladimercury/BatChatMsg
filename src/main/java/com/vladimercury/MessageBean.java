package com.vladimercury;

import java.util.List;

/**
 * Created by vladimercury on 6/12/16.
 */

public class MessageBean {
    private MessageJDBCTemplate messageJDBCTemplate;

    public MessageBean(){
        this.messageJDBCTemplate = new MessageJDBCTemplate();
        this.messageJDBCTemplate.setDataSource(new MvcConfig().dataSource());
    }

    public void setMessage(String message){
        this.messageJDBCTemplate.create(1, 1, message);
    }

    public String getMessage(){
        List<Message> messages = this.messageJDBCTemplate.listMessages();
        StringBuilder sb = new StringBuilder();
        for (Message message : messages){
            sb.append(message.getContent());
            sb.append("<br>");
        }
        return sb.toString();
    }
}
