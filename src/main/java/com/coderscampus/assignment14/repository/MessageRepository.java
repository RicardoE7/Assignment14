package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Message;

@Repository
public class MessageRepository {
    private List<Message> messages = new ArrayList<>();

    public void saveMessage(Message message) {
        messages.add(message);
    }

    public List<Message> findMessagesByChannelId(String channelId) {
        return messages.stream()
                .filter(message -> message.getChannelId().equals(channelId))
                .collect(Collectors.toList());
    }
}