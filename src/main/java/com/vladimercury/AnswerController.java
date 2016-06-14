package com.vladimercury;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Created by vladimercury on 6/13/16.
 */
@Controller
public class AnswerController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Answer answer(Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) throws Exception{
        return new Answer(simpMessageHeaderAccessor.getSessionId() + ": " +  message.getContent() + "!");
    }
}
