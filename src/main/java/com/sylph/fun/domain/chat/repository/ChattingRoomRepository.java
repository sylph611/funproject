package com.sylph.fun.domain.chat.repository;

import com.sylph.fun.domain.chat.entity.ChattingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChattingRoomRepository extends JpaRepository<ChattingRoom, Long> {
}
