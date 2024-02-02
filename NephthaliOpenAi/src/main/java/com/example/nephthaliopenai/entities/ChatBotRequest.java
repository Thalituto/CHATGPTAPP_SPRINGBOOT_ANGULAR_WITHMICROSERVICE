package com.example.nephthaliopenai.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@NoArgsConstructor@AllArgsConstructor
public class ChatBotRequest {

    private String model;
    private List<ChatBotRequestMessage> messages;

    public ChatBotRequest(ApiRequest request){
        this.model="gpt-3.5-turbo";
        this.messages=List.of(new ChatBotRequestMessage(request));
    }
}
