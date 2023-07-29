package com.sylph.fun.domain.chat.web.dto;

import com.sylph.fun.domain.chat.entity.Chat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatDto {

    private String id;
    private String name;
    private String password;
    private int maxCount;

    @Builder
    public ChatDto(String id, String name, String password, int maxCount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.maxCount = maxCount;
    }

    public static ChatDto of(Chat chat) {
        return ChatDto.builder()
                .id(chat.getId().toString())
                .name(chat.getName())
                .maxCount(chat.getMaxCount())
                .build();
    }

    public static List<ChatDto> ofList(List<Chat> chatList) {
        return chatList.stream()
                .map(ChatDto::of)
                .toList();
    }
}
