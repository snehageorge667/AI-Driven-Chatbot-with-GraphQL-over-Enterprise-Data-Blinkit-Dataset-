package com.example.blinkit.service;

import org.springframework.stereotype.Service;

@Service
public class IntentService {

    public String extractCategory(String message) {
        String lower = message.toLowerCase();

        if (lower.contains("fruit")) {
            return "Fruits and Vegetables";
        }
        if (lower.contains("drink")) {
            return "Soft Drinks";
        }
        if (lower.contains("frozen")) {
            return "Frozen Foods";
        }

        return "Fruits and Vegetables"; // safe default
    }
}
