package com.vladimercury;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vladimercury on 6/11/16.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Throwable {
//        MessageJDBCTemplate messageJDBCTemplate = new MvcConfig().messageJDBCTemplate();
//        messageJDBCTemplate.create(1, 1, "Запускаем гуся работяги!");
//        System.out.println("Listing messages:");
//        List<Message> messages = messageJDBCTemplate.listMessages();
//        for (Message message : messages){
//            System.out.println("" + message.getUser_id() + " " + message.getRoom_id() + " : " + message.getContent());
//        }
        SpringApplication.run(Application.class, args);
    }
}
