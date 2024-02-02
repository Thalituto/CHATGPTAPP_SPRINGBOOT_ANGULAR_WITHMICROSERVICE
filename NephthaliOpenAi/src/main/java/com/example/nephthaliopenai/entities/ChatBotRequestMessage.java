package com.example.nephthaliopenai.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ChatBotRequestMessage {

    private String role;
    private String content;

    public ChatBotRequestMessage(ApiRequest request){
        this.role="user";
        this.content=request.getMessage();
    }
}

