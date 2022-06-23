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
        final ErrorResponseDto response = ErrorResponseDto.create()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).code("SYSTEM").message(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductListNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> productListNotFountExceptionHandler(
        ProductListNotFoundException e) {
        final ErrorResponseDto response = ErrorResponseDto.create()
            .code(ErrorCode.PRODUCT_NOT_FOUND.getCode())
            .status(ErrorCode.PRODUCT_NOT_FOUND.getStatus())
            .message(ErrorCode.PRODUCT_NOT_FOUND.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNoTargetException.class)
    public ResponseEntity<ErrorResponseDto> productExceptionHandler(ProductNoTargetException e) {
        final ErrorResponseDto response = ErrorResponseDto.create()
            .code(ErrorCode.NO_TARGET_PRODUCT.getCode())
            .status(ErrorCode.NO_TARGET_PRODUCT.getStatus())
            .message(ErrorCode.NO_TARGET_PRODUCT.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
