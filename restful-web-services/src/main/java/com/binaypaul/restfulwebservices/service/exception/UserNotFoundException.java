package com.binaypaul.restfulwebservices.service.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("USER_NOT_FOUND");
    }
}
