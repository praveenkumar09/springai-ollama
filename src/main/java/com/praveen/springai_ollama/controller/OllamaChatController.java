package com.praveen.springai_ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OllamaChatController {

    private final ChatClient chatClient;

    public OllamaChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("chat")
    public String chat(@RequestParam String message){
        return chatClient.prompt(message).call().content();
    }
}
