package com.waw.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductRequestDto {

    private String productName;
    private String type;
    private int price;
}
