package com.example.blinkit.dto;

public class ChatResponse {
    private String answer;
    private Object data;

    public ChatResponse(String answer, Object data) {
        this.answer = answer;
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public Object getData() {
        return data;
    }
}
