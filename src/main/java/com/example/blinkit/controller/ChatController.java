package com.example.blinkit.controller;

import com.example.blinkit.dto.ChatResponse;
import com.example.blinkit.service.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private GraphQLService graphQLService;

    @QueryMapping
    public ChatResponse chat(@Argument String message) {
        return graphQLService.handleChat(message);
    }
}
