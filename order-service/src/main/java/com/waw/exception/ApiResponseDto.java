package com.waw.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponseDto<V> {

    private int resultCode = 1;
    private String resultMessage = "SUCCESS";

    private V data;

    public ApiResponseDto(V data) {
        this.data = data;
    }
}
