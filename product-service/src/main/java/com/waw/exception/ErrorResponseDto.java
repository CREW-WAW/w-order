package com.waw.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ErrorResponseDto {

    private String code;
    private String message;
    private int status;

    public ErrorResponseDto code(String code) {
        this.code = code;
        return this;
    }

    public ErrorResponseDto status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponseDto message(String message) {
        this.message = message;
        return this;
    }

    static public ErrorResponseDto create() {
        return new ErrorResponseDto();
    }

    public ErrorResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
