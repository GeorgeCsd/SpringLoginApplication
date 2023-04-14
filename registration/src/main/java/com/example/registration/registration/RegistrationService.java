package com.example.registration.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class RegistrationService {

    public String register(RegistrationRequest request) {
        return "it works";
    }
}
