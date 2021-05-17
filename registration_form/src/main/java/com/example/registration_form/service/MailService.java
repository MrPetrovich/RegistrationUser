package com.example.registration_form.service;

import com.example.registration_form.exception.UserInfoException;

public interface MailService {

    void prepareAndSendEmail(String key, String response) throws UserInfoException;
}
