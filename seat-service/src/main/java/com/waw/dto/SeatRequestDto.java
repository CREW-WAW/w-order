package com.waw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeatRequestDto {

    private long seatNum;
    private String ownerId;
    private String tableNm;
    private String LimitPer;
    private String useYn;
    private String status;
}
