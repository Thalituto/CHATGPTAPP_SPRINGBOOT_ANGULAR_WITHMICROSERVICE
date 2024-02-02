package com.example.nephthaliopenai.services;

import com.example.nephthaliopenai.entities.ApiRequest;
import com.example.nephthaliopenai.entities.ApiResponse;
import com.example.nephthaliopenai.entities.ChatBotResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class AiRequestProcessor {

    private final ChatBotRequestBuilder chatbot;

    public ApiResponse process(ApiRequest request) {
        log.info("### -> Incoming request: {}", request.getMessage());

        try {
            ChatBotResponse response = chatbot.executeRequest(request);
            log.info("### -> ChatGPT response: {}", response);
            return new ApiResponse(response);
        } catch (Exception e) {
            // Gérer les exceptions (enregistrer, retourner une réponse d'erreur, etc.)
            log.error("Erreur lors du traitement de la requête", e);
            return new ApiResponse("Une erreur s'est produite lors du traitement de la requête.");
        }
    }
}
