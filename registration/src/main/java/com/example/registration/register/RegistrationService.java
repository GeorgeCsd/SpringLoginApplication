package com.example.registration.register;

import com.example.registration.appuser.AppUser;
import com.example.registration.appuser.AppUserRole;
import com.example.registration.appuser.AppUserService;
import com.example.registration.register.token.ConfirmationToken;
import com.example.registration.register.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class  RegistrationService {

    private final AppUserService appUserService;

    private final  EmailValidator emailValidator;

    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }
        return appUserService.signUpUser(new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(),request.getPassword(), AppUserRole.USER));
    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken=confirmationTokenService.getToken(token).orElseThrow(()->new IllegalStateException("Token not found"));
        if(confirmationToken.getConfirmedAt()!=null){
            throw new IllegalStateException("Email already confirmed");
        }
        LocalDateTime expiredAt=confirmationToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token has expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());
        return "confirmed";

    }
}
