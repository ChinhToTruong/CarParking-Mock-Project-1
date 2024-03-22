package com.example.carparking.exception;

import com.example.carparking.dto.ResponseDto;
import com.example.carparking.exception.custom.EmployeeAlreadyExistedException;
import com.example.carparking.exception.custom.EmployeeNotFoundException;
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
    public ResponseEntity<ResponseDto> handleGlobalException(Exception ex) {
        log.error("handleGlobalException: ", ex);
        return ResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseDto> handleUserNotFoundException(EmployeeNotFoundException ex) {
        log.error("handleUserNotFoundException: ", ex);
        return ResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ExceptionHandler(EmployeeAlreadyExistedException.class)
    public ResponseEntity<ResponseDto> handleEmployeeAlreadyExistedException(EmployeeAlreadyExistedException ex) {
        log.error("handleEmployeeAlreadyExistedException: ", ex);
        return ResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String title = error.getObjectName();
                    String message = error.getDefaultMessage();
                    errors.put(title, message);
                }
        );
        return ResponseDto.build()
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withErrors(errors)
                .toEntity();
    }

}
