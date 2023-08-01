package com.sylph.fun.domain.game;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class GameController {

    private final GameService gameService;

    @MessageMapping("/pub/game/{id}")
    @SendTo("/sub/game/{id}")
    public GameDto game(@DestinationVariable Long id, GameDto gameDto) {
        return gameDto;
    }

}