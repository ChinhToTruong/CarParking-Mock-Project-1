package com.example.carparking.exception.custom;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{
    private HttpStatus status;

    private String message;

    private String[] errors = new String[]{};

    public UserNotFoundException(HttpStatus status, String message, String[] errors) {
        super(message);
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public UserNotFoundException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public UserNotFoundException( String message) {
        super(message);
        this.message = message;
    }
}
