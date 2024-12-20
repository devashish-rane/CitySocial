package com.devashish.citysocial.one.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BasePrinter implements CommandLineRunner {

    private final WebServerApplicationContext serverContext;


    public BasePrinter(WebServerApplicationContext serverContext) {
        this.serverContext = serverContext;
    }

    @Override
    public void run(String... args) {
        String baseUrl = "http://localhost:" + serverContext.getWebServer().getPort();
        System.out.println("Base URL of the Spring Boot application: " + baseUrl);
    }
}

