package com.sylph.fun.domain.chat.web;

import com.sylph.fun.domain.chat.service.ChatService;
import com.sylph.fun.domain.chat.web.dto.ChatDto;
import com.sylph.fun.domain.chat.web.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/api/chat")
    public List<ChatDto> getList() {
        return ChatDto.ofList(chatService.getList());
    }

    @MessageMapping("/pub/chat/room/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    public MessageDto message(@PathVariable String roomId, MessageDto messageDto) {
        return messageDto;
    }

}