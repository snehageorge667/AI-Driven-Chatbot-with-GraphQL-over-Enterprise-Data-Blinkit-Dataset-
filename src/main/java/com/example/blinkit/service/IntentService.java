package com.example.blinkit.service;

import org.springframework.stereotype.Service;

@Service
public class IntentService {

    public boolean isDatasetQuery(String message) {
        String msg = message.toLowerCase();

        return msg.contains("price")
                || msg.contains("cost")
                || msg.contains("available")
                || msg.contains("stock")
                || msg.contains("apple")
                || msg.contains("banana")
                || msg.contains("milk");
    }
}
