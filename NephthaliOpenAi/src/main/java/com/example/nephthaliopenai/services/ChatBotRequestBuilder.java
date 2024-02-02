package com.example.nephthaliopenai.services;

import com.example.nephthaliopenai.entities.ApiRequest;
import com.example.nephthaliopenai.entities.ChatBotRequest;
import com.example.nephthaliopenai.entities.ChatBotResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatBotRequestBuilder {

    private final RestTemplate rest;
    private final String URL;
    private final String SECRET;

    public ChatBotRequestBuilder(@Value("${ai.secret}") String secret,
                                 @Value("${ai.url}") String url) {
        this.URL = url;
        this.SECRET = secret;
        this.rest = new RestTemplate();
    }

    public ChatBotResponse executeRequest(ApiRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + SECRET);

        HttpEntity<ChatBotRequest> httpEntity = new HttpEntity<>(new ChatBotRequest(request), headers);

        try {
            ResponseEntity<ChatBotResponse> responseEntity = rest.postForEntity(URL, httpEntity, ChatBotResponse.class);
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            // Gérer les erreurs HTTP (par exemple, afficher un message approprié, enregistrer les erreurs, etc.)
            throw e; // ou retourner une réponse d'erreur personnalisée
        } catch (Exception e) {
            // Gérer d'autres exceptions
            throw new RuntimeException("Une erreur s'est produite lors de l'appel à l'API.", e);
        }
    }
}
