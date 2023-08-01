package com.sylph.fun.domain.chat.web.dto;

import com.sylph.fun.domain.chat.entity.ChattingRoom;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChattingRoomDto {

    private Long id;
    private String name;
    private String password;
    private int maxCount;

    @Builder
    public ChattingRoomDto(Long id, String name, String password, int maxCount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.maxCount = maxCount;
    }

    public static ChattingRoomDto of(ChattingRoom chattingRoom) {
        return ChattingRoomDto.builder()
                .id(chattingRoom.getId())
                .name(chattingRoom.getName())
                .maxCount(chattingRoom.getMaxCount())
                .build();
    }

    public static List<ChattingRoomDto> ofList(List<ChattingRoom> chattingRoomList) {
        return chattingRoomList.stream()
                .map(ChattingRoomDto::of)
                .toList();
    }
}
