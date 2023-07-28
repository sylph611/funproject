package com.sylph.fun.domain.chat.service;

import com.sylph.fun.domain.chat.entity.Chat;
import com.sylph.fun.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public List<Chat> getList() {
        return chatRepository.findAll();
    }

    public Chat get(String id) {
        return chatRepository.findById(UUID.fromString(id)).orElseThrow();
    }

    public Chat create(String name, String password) {
        return chatRepository.save(Chat.of(name,password));
    }

    public void delete(String id, String password) throws Exception {
        Chat chat = chatRepository.findById(UUID.fromString(id)).orElseThrow();
        if(!chat.getPassword().equals(password)) throw new Exception("패스워드가 다릅니다.");
    }
}
