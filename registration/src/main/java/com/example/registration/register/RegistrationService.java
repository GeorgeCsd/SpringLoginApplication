package com.example.registration.register;

import com.example.registration.appuser.AppUser;
import com.example.registration.appuser.AppUserRole;
import com.example.registration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;

    private final  EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }
        return appUserService.signUpUser(new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(),request.getPassword(), AppUserRole.USER));
    }
}
