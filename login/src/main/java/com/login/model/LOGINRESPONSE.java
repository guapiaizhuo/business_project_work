package com.login.model;

public enum LOGINRESPONSE {
    SUCCESS("登录成功"),
    FAULT("登录失败"),
    OTHERS("其他异常");
    private final String message;


    LOGINRESPONSE(String message) {
        this.message = message;
    }
}
