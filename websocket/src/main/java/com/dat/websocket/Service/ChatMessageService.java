package com.dat.websocket.Service;

import com.dat.websocket.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    ChatMessage save(ChatMessage chatMessage);

    List<ChatMessage> findChatMessages(
            String senderId,
            String recipientId
    );
}
