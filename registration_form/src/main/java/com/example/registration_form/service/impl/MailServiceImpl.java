package com.example.registration_form.service.impl;

import com.example.registration_form.dao.entity.UserInfo;
import com.example.registration_form.exception.UserInfoException;
import com.example.registration_form.service.MailService;
import com.example.registration_form.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MailServiceImpl implements MailService {

    private final UserInfoService userInfoService;

    @Override
    public void prepareAndSendEmail(String key, String response) throws UserInfoException {
        UserInfo userInfo = userInfoService.findById(Integer.valueOf(key));
        if(userInfo!=null) {
            log.info("Send email to {}", userInfo.getEmail());
        }else{
            throw new UserInfoException();
        }
    }
}
