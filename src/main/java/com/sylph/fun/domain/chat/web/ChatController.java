package com.sylph.fun.domain.chat.web;

import com.sylph.fun.domain.chat.service.ChatService;
import com.sylph.fun.domain.chat.web.dto.ChatDto;
import com.sylph.fun.domain.chat.web.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/api/chat/list")
    @ResponseBody
    public List<ChatDto> getList() {
        return ChatDto.ofList(chatService.getList());
    }

    @GetMapping("/api/chat/{roomId}")
    @ResponseBody
    public ChatDto get(@PathVariable String roomId) {
        return ChatDto.of(chatService.get(roomId));
    }

    @PostMapping("/api/chat")
    @ResponseBody
    public ChatDto create(@RequestBody ChatDto chatDto) {
        return ChatDto.of(chatService.create(chatDto.getName(), chatDto.getPassword()));
    }

    @MessageMapping("/pub/chat")
    @SendTo("/sub/chat")
    public MessageDto message(MessageDto messageDto) {
        return messageDto;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }


}