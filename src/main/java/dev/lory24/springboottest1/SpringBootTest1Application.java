package dev.lory24.springboottest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTest1Application {
    public static TestCore service;

    public static void main(String[] args) {
        service = new TestCore();
        SpringApplication.run(SpringBootTest1Application.class, args);
    }
}
