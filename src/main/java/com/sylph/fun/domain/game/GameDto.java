package com.sylph.fun.domain.game;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameDto {

    private String turn;
    private String x;
    private String y;

    @Builder
    private GameDto(String turn, String x, String y) {
        this.turn = turn;
        this.x = x;
        this.y = y;
    }

}
