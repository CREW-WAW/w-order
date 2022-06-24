package com.waw.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    COMMON_CHECK_PARAMETER("C001", "파라미터를 확인해 주세요.."),

    PRODUCT_NOT_EXIST_LIST( "P001", "상품 목록 데이터가 없습니다."),
    PRODUCT_NO_TARGET("P002", "대상 상품이 없습니다."),

    KAFKA_NO_DATA("K001", "카프카 데이터가 없습니다."),
    KAFKA_PRODUCER_CHECK("K001", "카프카 프로듀서를 확인하세요."),
    KAFKA_CONSUMER_CHECK("K002", "카프카 컨슈머를 홛인하세요.");

    private final String code;
    private final String message;

    ErrorCode(final String code, final String message) {
        this.message = message;
        this.code = code;
    }
}
