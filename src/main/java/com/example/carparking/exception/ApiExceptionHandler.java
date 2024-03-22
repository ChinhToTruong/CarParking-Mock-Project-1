package com.example.carparking.exception;

import com.example.carparking.dto.response.EmployeeResponseDto;
import com.example.carparking.exception.custom.EmployeeAlreadyExistedException;
import com.example.carparking.exception.custom.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j2
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmployeeResponseDto> handleGlobalException(Exception ex) {
        log.error("handleGlobalException: ", ex);
        return EmployeeResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<EmployeeResponseDto> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("handleUserNotFoundException: ", ex);
        return EmployeeResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ExceptionHandler(EmployeeAlreadyExistedException.class)
    public ResponseEntity<EmployeeResponseDto> handleEmployeeAlreadyExistedException(EmployeeAlreadyExistedException ex) {
        log.error("handleEmployeeAlreadyExistedException: ", ex);
        return EmployeeResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String title = error.getObjectName();
                    String message = error.getDefaultMessage();
                    errors.put(title, message);
                }
        );
        return EmployeeResponseDto.build()
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withErrors(errors)
                .toEntity();
    }

}
