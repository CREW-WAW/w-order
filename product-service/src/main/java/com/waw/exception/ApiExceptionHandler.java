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
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).code("SYSTEM")
            .message(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorResponseDto> CommonException(
        CommonException e) {
        log.debug("Catch CommonException :: {}", e.getMessage());
        final ErrorResponseDto response = ErrorResponseDto.create()
            .code(e.getErrorCode().getCode())
            .message(e.getErrorCode().getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductDataException.class)
    public ResponseEntity<ErrorResponseDto> ProductDataException(
        ProductDataException e) {
        log.debug("Catch ProductDataException :: {}", e.getMessage());
        final ErrorResponseDto response = ErrorResponseDto.create()
            .code(e.getErrorCode().getCode())
            .message(e.getErrorCode().getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(KafkaDataException.class)
    public ResponseEntity<ErrorResponseDto> KafkaDataException(KafkaDataException e) {
        log.debug("Catch KafkaDataException :: {}", e.getMessage());
        final ErrorResponseDto response = ErrorResponseDto.create()
            .code(e.getErrorCode().getCode())
            .message(e.getErrorCode().getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
