package com.example.registration_form.service;

import com.example.registration_form.dao.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    Integer addUser(UserInfo newUserInfo);

    List<UserInfo> getAllUsers();

    UserInfo findById(Integer id);
}
