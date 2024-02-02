package com.example.nephthaliopenai.controllers;

import com.example.nephthaliopenai.entities.ApiRequest;
import com.example.nephthaliopenai.entities.ApiResponse;
import com.example.nephthaliopenai.entities.ChatBotResponse;
import com.example.nephthaliopenai.services.AiRequestProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/api/v1")
@RestController
@AllArgsConstructor
public class ApiController {

    private final AiRequestProcessor aiProcessor;

    @PostMapping(value = "/ai/request")
    public ResponseEntity<ApiResponse> get(@RequestBody ApiRequest request){
        return ResponseEntity.ok(aiProcessor.process(request));
    }
}
