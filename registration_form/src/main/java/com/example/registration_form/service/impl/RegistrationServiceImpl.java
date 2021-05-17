package com.example.registration_form.service.impl;

import com.example.registration_form.dao.entity.UserInfo;
import com.example.registration_form.jms.KafkaProducer;
import com.example.registration_form.service.RegistrationService;
import com.example.registration_form.service.UserInfoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RegistrationServiceImpl implements RegistrationService {

    private final UserInfoService userInfoService;

    private final KafkaProducer kafkaProducerService;

    @Override
    public void registration(String login, String password, String email, String fullName){
        UserInfo userInfo = new UserInfo();
        userInfo.setLogin(login);
        userInfo.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
        userInfo.setEmail(email);
        userInfo.setFullName(fullName);

        Integer id = userInfoService.addUser(userInfo);
        Gson gson = new GsonBuilder().create();
        String userInfoJson = gson.toJson(userInfo);
        kafkaProducerService.sendMessage(id, userInfoJson);
    }
}
