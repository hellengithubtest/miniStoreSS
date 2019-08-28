package com.store.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApp.class);
    }
}
