package dev.lory24.springboottest1.rest.controllers;

import dev.lory24.springboottest1.rest.resources.PeopleAmount;
import dev.lory24.springboottest1.services.PeopleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public PeopleAmount getPeopleAmount() {
        return new PeopleAmount(peopleService.getPeople().size());
    }
}
