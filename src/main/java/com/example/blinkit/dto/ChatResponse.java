package com.example.blinkit.dto;

public class ChatResponse {

    private String answer;
    private String source;

    public ChatResponse(String answer, String source) {
        this.answer = answer;
        this.source = source;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSource() {
        return source;
    }
}
