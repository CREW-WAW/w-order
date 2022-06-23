package com.waw.exception;

public class ProductNoTargetException extends NullPointerException {

    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    public ProductNoTargetException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
