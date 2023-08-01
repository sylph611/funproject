package com.sylph.fun.domain.chat.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "chattingRoom")
public class ChattingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int maxCount;

    @Builder
    private ChattingRoom(Long id, String name, String password, int maxCount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.maxCount = maxCount;
    }

    public static ChattingRoom of(String name, String password, int maxCount) {
        return ChattingRoom.builder()
                .name(name)
                .password(password)
                .maxCount(maxCount)
                .build();
    }

    public static ChattingRoom of(String name, String password) {
        return ChattingRoom.of(name,password,2);
    }
}
