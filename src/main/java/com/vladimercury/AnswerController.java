package com.vladimercury;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimercury on 6/13/16.
 */
@Controller
public class AnswerController {
    private static List<Answer> history = new ArrayList<Answer>();

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Answer answer(Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) throws Exception{
        Answer ans = new Answer(simpMessageHeaderAccessor.getSessionId() + ": " +  message.getContent() + "!");
        history.add(ans);
        System.out.println(history.size());
        return ans;
    }
}
