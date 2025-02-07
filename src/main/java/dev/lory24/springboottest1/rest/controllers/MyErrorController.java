package dev.lory24.springboottest1.rest.controllers;

import dev.lory24.springboottest1.rest.resources.Error;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public Error handleError(final HttpServletRequest request) {
        // Ottieni l'errore riscontrato
        final Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // Errore 404
        if (statusCode == 404) {
            return new Error(false, "Risorsa non trovata!");
        }

        // Errore generico
        return new Error(false, "Errore generico: " + statusCode);
    }
}