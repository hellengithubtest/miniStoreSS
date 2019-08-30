package com.store.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication(exclude = IntegrationAutoConfiguration.class)
public class StoreApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApp.class);
    }
}
