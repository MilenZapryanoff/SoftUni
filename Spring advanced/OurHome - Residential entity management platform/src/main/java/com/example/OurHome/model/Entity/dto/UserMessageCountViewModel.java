package com.example.OurHome.model.Entity.dto;

import com.example.OurHome.model.Entity.Message;

import java.util.ArrayList;
import java.util.List;

public class UserMessageCountViewModel {

    private Long id;
    private List<Message> messages;

    public UserMessageCountViewModel() {
        messages = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
