package com.waw.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_EXIST_PRODUCT_LIST(801, "P001", "상품 목록 데이터가 없습니다."),
    PRODUCT_NOT_FOUND(802, "P002", "등록할 상품을 등록해주세요."),
    NO_TARGET_PRODUCT(803, "P003", "대상 상품이 없습니다.");

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
