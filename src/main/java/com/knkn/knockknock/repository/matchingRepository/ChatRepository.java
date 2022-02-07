package com.knkn.knockknock.repository.matchingRepository;

import com.knkn.knockknock.domain.matching.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    ArrayList<Chat> findByRoomIDEquals(Long roomID);
}