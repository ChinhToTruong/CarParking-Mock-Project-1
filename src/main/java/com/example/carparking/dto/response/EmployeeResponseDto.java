package com.example.carparking.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponseDto<T> {
    @JsonIgnore
    private HttpStatus httpStatus = HttpStatus.OK;
    @JsonIgnore
    private HttpHeaders headers;

    private int code;

    private Boolean success = true;

    private String message;

    private T data;

    private Map<String, Object> errors;


    public static <T> EmployeeResponseDto<T> build(){
        return new EmployeeResponseDto<>();
    }

    @PostConstruct
    private void init() {
        httpStatus = HttpStatus.OK;
        code = httpStatus.value();
        errors = new HashMap<String, Object>();
    }

    public EmployeeResponseDto<T> withHttpStatus(HttpStatus status){
        this.httpStatus = status;
        this.code = status.value();
        return this;
    }

    public EmployeeResponseDto<T> withCode(int code){
        this.code = code;
        return this;
    }

    public EmployeeResponseDto<T> withData(T data){
        this.data = data;
        return this;
    }

    public EmployeeResponseDto<T> withSuccess(boolean success){
        this.success = success;
        return this;
    }

    public EmployeeResponseDto<T> withHttpHeaders(HttpHeaders headers){
        this.headers = headers;
        return this;
    }

    public EmployeeResponseDto<T> withMessage(String message){
        this.message = message;
        return this;
    }

    public EmployeeResponseDto<T> withErrors(Map<String, Object> errors){
        this.errors = errors;
        return this;
    }

    public ResponseEntity<EmployeeResponseDto> toEntity(){
        return new ResponseEntity<>(this, headers, httpStatus);
    }

}
