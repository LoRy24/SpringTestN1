package dev.lory24.springboottest1.rest.controllers;

import dev.lory24.springboottest1.rest.resources.Health;
import dev.lory24.springboottest1.services.CountingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final CountingService countingService;
    public HealthController(CountingService countingService) {
        this.countingService = countingService;
    }

    @GetMapping("/health")
    public Health getHealth() {
        countingService.increment();
        return new Health(true, "Sono più in salute di te hahaha! Mi hai controllato " + countingService.getCount() + " volte.");
    }
}
