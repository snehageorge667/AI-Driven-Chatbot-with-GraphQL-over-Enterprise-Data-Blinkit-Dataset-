package com.example.blinkit.controller;

import com.example.blinkit.dto.ChatRequest;
import com.example.blinkit.dto.ChatResponse;
import com.example.blinkit.service.GraphQLService;
import com.example.blinkit.service.IntentService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final IntentService intentService;
    private final GraphQLService graphQLService;

    public ChatController(IntentService intentService,
                          GraphQLService graphQLService) {
        this.intentService = intentService;
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String category = intentService.extractCategory(request.getMessage());

        Object data = graphQLService.fetchProductsByCategory(category);

        return new ChatResponse(
                "Here are products from category: " + category,
                data
        );
    }
}
