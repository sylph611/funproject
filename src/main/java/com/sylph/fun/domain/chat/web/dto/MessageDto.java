package com.sylph.fun.domain.chat.web.dto;

import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

@Data
public class MessageDto {
    private String sender;
    private String message;
}
