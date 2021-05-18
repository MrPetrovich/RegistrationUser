package com.example.registration_form.service.impl;

import com.example.registration_form.dao.entity.UserInfo;
import com.example.registration_form.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;
import java.util.List;

@Slf4j
@SpringBootTest
class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void addUser() {
        String password = "test_password";
        UserInfo userInfo = new UserInfo();
        userInfo.setLogin("test");
        userInfo.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
        userInfo.setEmail("test@test");
        userInfo.setFullName("Test Test Test");
        userInfoService.addUser(userInfo);
        log.info(userInfo.getPassword());
        List<UserInfo> userInfoList = userInfoService.getAllUsers();
        Assertions.assertFalse(userInfoList.isEmpty());
        log.info("Found in database {} user", userInfoList.size());
        Assertions.assertTrue(userInfoList.contains(userInfo));
    }

    @Test
    void findByIdTest() {
    }
}