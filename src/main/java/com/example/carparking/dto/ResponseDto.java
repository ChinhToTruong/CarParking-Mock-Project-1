package com.example.carparking.dto;

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
public class ResponseDto<T> {
    @JsonIgnore
    private HttpStatus httpStatus = HttpStatus.OK;
    @JsonIgnore
    private HttpHeaders headers;

    private int code;

    private Boolean success = true;

    private String message;

    private T data;

    private Map<String, Object> errors;


    public static <T> ResponseDto<T> build(){
        return new ResponseDto<>();
    }

    @PostConstruct
    private void init() {
        httpStatus = HttpStatus.OK;
        code = httpStatus.value();
        errors = new HashMap<String, Object>();
    }

    public ResponseDto<T> withHttpStatus(HttpStatus status){
        this.httpStatus = status;
        this.code = status.value();
        return this;
    }

    public ResponseDto<T> withCode(int code){
        this.code = code;
        return this;
    }

    public ResponseDto<T> withData(T data){
        this.data = data;
        return this;
    }

    public ResponseDto<T> withSuccess(boolean success){
        this.success = success;
        return this;
    }

    public ResponseDto<T> withHttpHeaders(HttpHeaders headers){
        this.headers = headers;
        return this;
    }

    public ResponseDto<T> withMessage(String message){
        this.message = message;
        return this;
    }

    public ResponseDto<T> withErrors(Map<String, Object> errors){
        this.errors = errors;
        return this;
    }

    public ResponseEntity<ResponseDto> toEntity(){
        return new ResponseEntity<>(this, headers, httpStatus);
    }

}
