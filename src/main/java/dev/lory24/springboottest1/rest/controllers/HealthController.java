package dev.lory24.springboottest1.controllers;

import dev.lory24.springboottest1.rest.resources.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Health getHealth() {
        return new Health(true, "Healthy!");
    }
}
