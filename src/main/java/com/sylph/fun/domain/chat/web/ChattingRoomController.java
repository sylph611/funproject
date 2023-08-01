package com.sylph.fun.domain.chat.web;

import com.sylph.fun.domain.chat.service.ChattingRoomService;
import com.sylph.fun.domain.chat.web.dto.ChattingRoomDto;
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
public class ChattingRoomController {

    private final ChattingRoomService chattingRoomService;

    @GetMapping("/api/chat/list")
    @ResponseBody
    public List<ChattingRoomDto> getList() {
        return ChattingRoomDto.ofList(chattingRoomService.getList());
    }

    @GetMapping("/api/chat/{roomId}")
    @ResponseBody
    public ChattingRoomDto get(@PathVariable Long roomId) {
        return ChattingRoomDto.of(chattingRoomService.get(roomId));
    }

    @PostMapping("/api/chat")
    @ResponseBody
    public ChattingRoomDto create(@RequestBody ChattingRoomDto chattingRoomDto) {
        return ChattingRoomDto.of(chattingRoomService.create(chattingRoomDto.getName(), chattingRoomDto.getPassword()));
    }

    @MessageMapping("/pub/chat/{id}")
    @SendTo("/sub/chat/{id}")
    public MessageDto message(@DestinationVariable Long id, MessageDto messageDto) {
        return messageDto;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }


}