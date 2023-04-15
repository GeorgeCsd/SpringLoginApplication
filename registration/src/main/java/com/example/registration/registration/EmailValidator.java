package com.example.registration.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service

public class EmailValidator implements Predicate<String> { //takes a single argument and returns a boolean value


    @Override
    public boolean test(String s) {
        // TODO:Regex to validate email
        return true;
    }
}
