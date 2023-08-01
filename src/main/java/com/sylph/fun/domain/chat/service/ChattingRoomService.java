package com.sylph.fun.domain.chat.service;

import com.sylph.fun.domain.chat.entity.ChattingRoom;
import com.sylph.fun.domain.chat.repository.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChattingRoomService {

    private final ChattingRoomRepository chattingRoomRepository;

    public List<ChattingRoom> getList() {
        return chattingRoomRepository.findAll();
    }

    public ChattingRoom get(Long id) {
        return chattingRoomRepository.findById(id).orElseThrow();
    }

    public ChattingRoom create(String name, String password) {
        return chattingRoomRepository.save(ChattingRoom.of(name,password));
    }

    public void delete(Long id, String password) throws Exception {
        ChattingRoom chattingRoom = chattingRoomRepository.findById(id).orElseThrow();
        if(!chattingRoom.getPassword().equals(password)) throw new Exception("패스워드가 다릅니다.");
    }
}
