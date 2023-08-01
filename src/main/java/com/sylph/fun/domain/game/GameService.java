package com.sylph.fun.domain.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    public GameDto processGame(GameDto gameDto) {

        return gameDto;
    }

}
