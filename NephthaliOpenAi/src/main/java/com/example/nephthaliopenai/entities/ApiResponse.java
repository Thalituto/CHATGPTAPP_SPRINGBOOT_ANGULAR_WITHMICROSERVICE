package com.example.nephthaliopenai.entities;


import com.example.nephthaliopenai.entities.chatbot_DTO.Message;
import com.example.nephthaliopenai.entities.chatbot_DTO.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String response;

    public ApiResponse(ChatBotResponse chatbotResponse){
        this.response=chatbotResponse.getChoices().stream().findFirst()
                .map(Choice::getMessage).map(Message::getContent).
    orElse("Error. Could not fetch response from CHatGPT");
    }
}
