package com.vladimercury;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MessageJDBCTemplate implements MessageDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer user_id, Integer room_id, String content) {
        String SQL = "insert into messages (user_id, room_id, content) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, user_id, room_id, content);
        System.out.println("Created msg = " + content);
    }

    @Override
    public Message getMessage(Integer id) {
        String SQL = "select * from messages where message_id = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new MessageMapper());
    }

    @Override
    public List<Message> listMessages() {
        String SQL = "select * from messages";
        return jdbcTemplateObject.query(SQL, new MessageMapper());
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from messages where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted msg with id = " + id);
    }
}
