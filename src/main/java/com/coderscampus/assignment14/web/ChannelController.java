package com.coderscampus.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.MessageRepository;

import java.util.List;

@Controller
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/{channelId}")
    public String getChannel(@PathVariable String channelId) {
        return "channel";
    }

    @PostMapping("/{channelId}/messages")
    @ResponseBody
    public void postMessage(@PathVariable String channelId, @RequestBody Message message) {
        message.setChannelId(channelId);
        messageRepository.saveMessage(message);
    }

    @GetMapping("/{channelId}/messages")
    @ResponseBody
    public List<Message> getMessages(@PathVariable String channelId) {
        return messageRepository.findMessagesByChannelId(channelId);
    }
}
