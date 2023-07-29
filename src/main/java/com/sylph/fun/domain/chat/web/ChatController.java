package com.sylph.fun.domain.chat.web;

import com.sylph.fun.domain.chat.service.ChatService;
import com.sylph.fun.domain.chat.web.dto.ChatDto;
import com.sylph.fun.domain.chat.web.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/api/chat/list")
    public List<ChatDto> getList() {
        return ChatDto.ofList(chatService.getList());
    }

    @GetMapping("/api/chat/{roomId}")
    public ChatDto get(@PathVariable String roomId) {
        return ChatDto.of(chatService.get(roomId));
    }

    @PostMapping("/api/chat")
    public ChatDto create(ChatDto chatDto) {
        return ChatDto.of(chatService.create(chatDto.getName(), chatDto.getPassword()));
    }

    @MessageMapping("/pub/chat/{roomId}")
    @SendTo("/sub/chat/{roomId}")
    public MessageDto message(@DestinationVariable String roomId, MessageDto messageDto) {
        return messageDto;
    }
    


}