package dev.lory24.springboottest1.rest.controllers;

import dev.lory24.springboottest1.SpringBootTest1Application;
import dev.lory24.springboottest1.rest.resources.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Health getHealth() {
        SpringBootTest1Application.service.totalHealthChecks++;
        return new Health(true, "Sono più in salute di te hahaha! Mi hai controllato " + SpringBootTest1Application.service.totalHealthChecks + " volte.");
    }
}
