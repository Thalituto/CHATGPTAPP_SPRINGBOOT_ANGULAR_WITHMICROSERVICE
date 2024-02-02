package com.example.nephthaliopenai.entities;


import com.example.nephthaliopenai.entities.chatbot_DTO.Choice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@NoArgsConstructor@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatBotResponse {

    private String id;
    private List<Choice>choices;
}
