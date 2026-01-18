package com.example.blinkit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class GraphQLService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Object fetchProductsByCategory(String category) {

        String query = """
        {
          productsByCategory(category: "%s") {
            productName
            price
            rating
          }
        }
        """.formatted(category);

        Map<String, Object> request = Map.of("query", query);

        Map<?, ?> response = restTemplate.postForObject(
                "http://localhost:8080/graphql",
                request,
                Map.class
        );

        return response.get("data");
    }
}
