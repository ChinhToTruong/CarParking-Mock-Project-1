package com.example.carparking.exception.custom;

import org.springframework.http.HttpStatus;

public class EmployeeAlreadyExistedException extends RuntimeException{
    private HttpStatus status;

    private String message;

    private String[] errors = new String[]{};

    public EmployeeAlreadyExistedException(HttpStatus status, String message, String[] errors) {
        super(message);
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public EmployeeAlreadyExistedException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public EmployeeAlreadyExistedException(String message) {
        super(message);
        this.message = message;
    }
}
