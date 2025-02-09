package dev.lory24.springboottest1.rest.resources;

public record PersonDetails(boolean success,
                            String username,
                            String firstName,
                            String lastName,
                            String message) { }
