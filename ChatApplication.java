package com.example.chatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the real-time chat application.
 * Run with: mvn spring-boot:run
 * Then open http://localhost:8080 in multiple browser tabs/windows to chat.
 */
@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }
}
