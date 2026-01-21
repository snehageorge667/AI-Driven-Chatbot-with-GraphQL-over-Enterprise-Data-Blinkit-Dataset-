package com.example.blinkit.llm;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class OllamaWarmup {

    private final OllamaService ollamaService;

    public OllamaWarmup(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostConstruct
    public void warmup() {
        // Small prompt to load model into memory
        ollamaService.askOllama("Hello");
    }
}
