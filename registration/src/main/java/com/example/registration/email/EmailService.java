package com.example.registration.email;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{
    @Override
    public void send(String to, String email) {

    }
}
