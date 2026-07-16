package com.example.recycle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.recycle.websocket.RobotHandler;

@Configuration
@EnableWebSocket
public class RobotConfig implements WebSocketConfigurer {

    private final RobotHandler robotHandler;

    public RobotConfig(RobotHandler robotHandler) {
        this.robotHandler = robotHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(robotHandler, "/robot")
                .setAllowedOrigins("*");
    }
}
