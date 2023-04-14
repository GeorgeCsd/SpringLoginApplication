package com.example.registration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){ //BCryptPasswordEncoder is a password encoder provided by the Spring Security framework for hashing and encoding passwords in Spring Boot applications. It is based on the Blowfish encryption algorithm and is considered a strong and secure way of encoding passwords.
        return new BCryptPasswordEncoder();
    };


}
