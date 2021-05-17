package com.example.registration_form.api;

import com.example.registration_form.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<Void> registrationUser(String login, String password, String email, String fullName){
        registrationService.registration(login, password, email, fullName);
        return ResponseEntity.ok().build();
    }

}
