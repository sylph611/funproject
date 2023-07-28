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
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int maxCount;

    @Builder
    private Chat(UUID id, String name, String password, int maxCount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.maxCount = maxCount;
    }

    public static Chat of(String name, String password, int maxCount) {
        return Chat.builder()
                .name(name)
                .password(password)
                .maxCount(maxCount)
                .build();
    }

    public static Chat of(String name, String password) {
        return Chat.of(name,password,2);
    }
}
