package com.example.blinkit.service;

import com.example.blinkit.dto.ChatResponse;
import com.example.blinkit.llm.OllamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphQLService {

    @Autowired
    private GroceryItemService groceryItemService;

    @Autowired
    private OllamaService ollamaService;

    /**
     * Dataset-first, LLM fallback
     */
    public ChatResponse handleChat(String message) {

        if (message == null || message.trim().isEmpty()) {
            return new ChatResponse("Please enter a valid question.", "system");
        }

        // 1️⃣ DATASET FIRST
        String datasetAnswer = groceryItemService.searchFromDataset(message);

        if (datasetAnswer != null) {
            return new ChatResponse(datasetAnswer, "dataset");
        }

        // 2️⃣ LLM FALLBACK
        try {
            String llmAnswer = ollamaService.askOllama(message);
            return new ChatResponse(llmAnswer, "llm");
        } catch (Exception e) {
            return new ChatResponse(
                    "LLM is currently unavailable.",
                    "error"
            );
        }
    }
}
