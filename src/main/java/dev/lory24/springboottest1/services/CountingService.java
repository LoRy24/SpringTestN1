package dev.lory24.springboottest1.services;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class CountingService {
    private int count = 0;

    public void increment() {
        count++;
    }
}
