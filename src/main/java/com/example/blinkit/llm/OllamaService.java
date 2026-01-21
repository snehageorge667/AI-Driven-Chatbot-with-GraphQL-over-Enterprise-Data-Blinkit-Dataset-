package com.example.blinkit.llm;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OllamaService {

    private final RestTemplate restTemplate;

    public OllamaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String askOllama(String prompt) {

        // Request body exactly matching Ollama API
        Map<String, Object> body = Map.of(
                "model", "phi3:mini",
                "prompt", prompt,
                "stream", false   // 🔴 MUST be false to avoid hanging
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response =
                    restTemplate.postForEntity(
                            "http://localhost:11434/api/generate",
                            request,
                            Map.class
                    );

            if (response.getBody() == null) {
                return "LLM returned empty response.";
            }

            Object text = response.getBody().get("response");
            return text != null
                    ? text.toString().trim()
                    : "LLM returned no text.";

        } catch (Exception e) {
            // IMPORTANT: never let LLM crash GraphQL
            e.printStackTrace();
            return "LLM is currently unavailable.";
        }
    }
}
