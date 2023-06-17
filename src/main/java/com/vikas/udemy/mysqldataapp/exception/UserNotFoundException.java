package com.vikas.udemy.mysqldataapp.exception;

public class UserNotFoundException extends RuntimeException{

    private final long userId;

    public UserNotFoundException(long userId) {
        super(String.format("User with id %d not found", userId));
        this.userId = userId;
    }
}
