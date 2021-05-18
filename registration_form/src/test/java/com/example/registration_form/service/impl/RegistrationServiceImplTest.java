package com.example.registration_form.service.impl;

import com.example.registration_form.dao.entity.UserInfo;
import com.example.registration_form.jms.KafkaProducer;
import com.example.registration_form.service.UserInfoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RegistrationServiceImplTest {

    @Mock
    private KafkaProducer kafkaProducer;

    @Mock
    private UserInfoService userInfoService;

    @Test
    void registration(){
        UserInfo userInfo = new UserInfo();
        userInfo.setLogin("login");
        userInfo.setPassword(Base64.getEncoder().encodeToString("password".getBytes()));
        userInfo.setEmail("email");
        userInfo.setFullName("full name");

        Gson gson = new GsonBuilder().create();
        String userInfoJson = gson.toJson(userInfo);

        Mockito.doReturn(8).when(userInfoService).addUser(userInfo);
        Integer id = userInfoService.addUser(userInfo);
        Assertions.assertTrue(id == 8);
        Mockito.doNothing().when(kafkaProducer).sendMessage(8, userInfoJson);
        kafkaProducer.sendMessage(id, userInfoJson);

        Mockito.verify(userInfoService, Mockito.times(1)).addUser(userInfo);
        Mockito.verify(kafkaProducer, Mockito.times(1)).sendMessage(8, userInfoJson);

    }
}