package com.login.model;

public enum AUTHORITY {
    USER("user"),
    ADMINISTRATOR("administrator"),
    SUPERADMINISTRATOR("superadministrator");

    private final String message;
    AUTHORITY(String message) {
        this.message = message;
    }
}
