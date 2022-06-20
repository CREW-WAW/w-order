package com.waw.exception;

public class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public ProductNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
