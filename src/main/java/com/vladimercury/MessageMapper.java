package com.vladimercury;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vladimercury on 6/12/16.
 */
public class MessageMapper implements RowMapper<Message> {
    public Message mapRow(ResultSet rs, int romNum) throws SQLException{
        Message message = new Message();
        message.setMessage_id(rs.getInt("message_id"));
        message.setUser_id(rs.getInt("user_id"));
        message.setRoom_id(rs.getInt("room_id"));
        message.setContent(rs.getString("content"));
        return message;
    }
}
