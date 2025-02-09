package dev.lory24.springboottest1.rest.controllers;

import dev.lory24.springboottest1.database.Person;
import dev.lory24.springboottest1.rest.resources.PeopleAmount;
import dev.lory24.springboottest1.rest.resources.PersonDetails;
import dev.lory24.springboottest1.services.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public PeopleAmount getPeopleAmount() {
        return new PeopleAmount(true, peopleService.getPeople().size());
    }

    @GetMapping("/{username}")
    public ResponseEntity<PersonDetails> getPersonDetails(@PathVariable String username) {
        PersonDetails result = preparePersonDetails(username);
        return ResponseEntity.status(result.success() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(result);
    }

    public PersonDetails preparePersonDetails(String username) {
        // Cerca la persona tramite l'username
        Optional<Person> person = peopleService.getPersonByUsername(username);

        // Ritorna i dettagli se presenti
        return person.map(value ->
                new PersonDetails(
                        true,
                        value.getUsername(),
                        value.getFirstName(),
                        value.getLastName(),
                        "Dati ottenuti con successo!"
                )
        ).orElseGet(() ->
                new PersonDetails(
                        false,
                        null,
                        null,
                        null,
                        "Persona non trovata!"
                )
        );
    }
}
