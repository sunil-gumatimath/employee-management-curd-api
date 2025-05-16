package com.example.employeemanagementsystem.exception;

public class UserNotFoundById extends RuntimeException {
    public UserNotFoundById(String message) {
        super(message);
    }
}
