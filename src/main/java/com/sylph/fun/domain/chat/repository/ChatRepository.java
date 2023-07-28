package com.sylph.fun.domain.chat.repository;

import com.sylph.fun.domain.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
