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
    private int maxCount;

    @Builder
    private ChatDto(String id, String name, int maxCount) {
        this.id = id;
        this.name = name;
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
