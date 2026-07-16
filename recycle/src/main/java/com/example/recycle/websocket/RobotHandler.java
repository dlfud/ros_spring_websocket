package com.example.recycle.websocket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class RobotHandler extends TextWebSocketHandler {


    private final SimpMessagingTemplate template;


    public RobotHandler(SimpMessagingTemplate template) {
        this.template = template;
    }


    @Override
    protected void handleTextMessage(
            WebSocketSession session,
            TextMessage message)
            throws Exception {


        String data = message.getPayload();


        System.out.println(data);


        template.convertAndSend(
                "/topic/status",
                data
        );
    }

    /*@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(payload);
        String topic = json.get("topic").asText();

        template.convertAndSend(
                "/topic/" + topic,
                json.get("data")
        );
    }*/
}