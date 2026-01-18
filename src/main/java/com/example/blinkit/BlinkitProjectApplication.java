package com.example.blinkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.blinkit")
public class BlinkitProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlinkitProjectApplication.class, args);
    }
}
