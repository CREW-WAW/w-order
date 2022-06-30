package com.waw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeatRequestDto {

    private int orderNum;
    private int totalPrice;
    private String userId;
}
