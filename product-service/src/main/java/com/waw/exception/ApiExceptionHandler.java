package com.waw.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> exceptionHandler(Exception e) {
        log.error("========= Method Not Allowed =========");
        final ErrorResponseDto response = ErrorResponseDto.create()
            .status(HttpStatus.METHOD_NOT_ALLOWED.value()).message(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> productExceptionHandler(ProductNotFoundException e) {
        final ErrorResponseDto response = ErrorResponseDto.create()
            .code(ErrorCode.PRODUCT_NOT_FOUND.getCode())
            .status(ErrorCode.PRODUCT_NOT_FOUND.getStatus())
            .message(ErrorCode.PRODUCT_NOT_FOUND.getMessage());

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
