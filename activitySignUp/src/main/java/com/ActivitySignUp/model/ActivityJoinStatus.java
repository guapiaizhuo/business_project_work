package com.ActivitySignUp.model;

public enum ActivityJoinStatus {
    SUCCESS("报名成功"),
    ACTIVITY_NOT_FOUND("无此活动"),
    ACTIVITY_FULL("超出报名人数"),
    OTHER_ERROR("其他错误");

    private final String message;

    ActivityJoinStatus(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
