package com.example.registration_form.service.impl;

import com.example.registration_form.dao.entity.UserInfo;
import com.example.registration_form.repository.UserInfoRepository;
import com.example.registration_form.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public Integer addUser(UserInfo newUserInfo) {
        UserInfo saved = userInfoRepository.save(newUserInfo);
        return saved.getId();
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoRepository.getOne(id);
    }
}
