package com.example.registration_form.service.impl;

import com.example.registration_form.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
class RegistrationServiceImplTest {

    private final RegistrationService registrationService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void registrationTest(){
        //registrationService.registration();
    }
}