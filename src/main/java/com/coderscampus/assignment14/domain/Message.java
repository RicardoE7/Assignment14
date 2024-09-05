package com.coderscampus.assignment14.domain;

import java.time.LocalDateTime;

public class Message {
    private Long messageId;
    private String content;
    private String username;
    private String channelId;
    private LocalDateTime timestamp;

    public Message(String content, String username, String channelId) {
        this.messageId = generateMessageId();
        this.content = content;
        this.username = username;
        this.channelId = channelId;
        this.timestamp = LocalDateTime.now();
    }

    private static Long messageCounter = 0L; 
    private synchronized Long generateMessageId() {
        return ++messageCounter;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", channelId='" + channelId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
