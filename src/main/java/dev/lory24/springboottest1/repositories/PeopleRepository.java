package dev.lory24.springboottest1.repositories;

import dev.lory24.springboottest1.database.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    /**
     * Questa funzione permette di trovare una persona tramite il suo username.
     *
     * @param username Username della persona da cercare.
     * @return Persona trovata (se esiste).
     */
    Optional<Person> findByUsername(String username);
}
