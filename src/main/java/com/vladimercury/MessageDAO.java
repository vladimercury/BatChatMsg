package com.vladimercury;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by vladimercury on 6/12/16.
 */
public interface MessageDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer user_id, Integer room_id, String content);
    public Message getMessage(Integer id);
    public List<Message> listMessages();
    public void delete(Integer id);
}
