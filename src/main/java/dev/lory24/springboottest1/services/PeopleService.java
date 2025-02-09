package dev.lory24.springboottest1.services;

import dev.lory24.springboottest1.database.Person;
import dev.lory24.springboottest1.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    /**
     * Costruttore della classe.
     *
     * @param peopleRepository Repository delle persone.
     */
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    /**
     * Questa funzione permette di ottenere tutte le persone presenti nel database.
     *
     * @return Lista di persone presenti nel database.
     */
    public List<Person> getPeople() {
        return peopleRepository.findAll();
    }

    /**
     * Questa funzione permette di trovare una persona tramite il suo username.
     *
     * @param username Username della persona da cercare.
     * @return Persona trovata (se esiste).
     */
    public Person getPersonByUsername(String username) {
        return peopleRepository.findByUsername(username).orElse(null);
    }
}
