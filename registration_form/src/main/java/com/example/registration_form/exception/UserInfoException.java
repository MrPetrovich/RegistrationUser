package com.example.registration_form.exception;

public class UserInfoException extends RuntimeException{
    public UserInfoException() {
        super("UserInfo is empty");
    }
}
