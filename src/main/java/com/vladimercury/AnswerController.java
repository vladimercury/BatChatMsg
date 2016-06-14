package com.vladimercury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimercury on 6/13/16.
 */
@Controller
public class AnswerController {
    private static Map<String, List<Answer>> history = new HashMap<String, List<Answer>>();
    private SimpMessageSendingOperations messageSendingOperations;

    @Autowired
    public AnswerController(SimpMessageSendingOperations messageSendingOperations){
        this.messageSendingOperations = messageSendingOperations;
    }

    private static String tagScreening(String str){
        str = str.replace("&", "&amp;");
        str = str.replace("<", "&lt;");
        str = str.replace(">", "&gt");
        return str;
    }

    @MessageMapping("/hello/{roomId}")
    public void answer(@DestinationVariable String roomId, Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) throws Exception{
        Answer ans = new Answer(simpMessageHeaderAccessor.getSessionId(), tagScreening(message.getContent()));
        if (!history.containsKey(roomId)){
            history.put(roomId, new ArrayList<Answer>());
        }
        history.get(roomId).add(ans);
        messageSendingOperations.convertAndSend("/topic/greetings/" + roomId, ans);
    }

    @MessageMapping("/history/{roomId}")
    public void getHistory(@DestinationVariable String roomId) throws Exception{
        if (!history.containsKey(roomId)){
            history.put(roomId, new ArrayList<Answer>());
        }
        List<Answer> thisChat = history.get(roomId);
        String[] authors = new String[thisChat.size()];
        String[] messages = new String[thisChat.size()];
        int index = 0;

        for (Answer answer : thisChat) {
            authors[index] = answer.getAuthor();
            messages[index] = answer.getContent();
            index++;
        }
        messageSendingOperations.convertAndSend("/topic/history/" + roomId, new History(authors, messages));
    }
}
