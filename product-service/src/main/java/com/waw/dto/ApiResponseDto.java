package com.waw.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApiResponseDto<T> {

    private int resultCode = HttpStatus.OK.value();
    private String resultMessage = "SUCCESS";

    private T data;

    public ApiResponseDto(T data) {
        this.data = data;
    }
}
