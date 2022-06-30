package com.waw.dto;

import com.waw.entity.Seat;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SeatResponseDto {

    private Long orderNum;
    private Long totalPrice;
    private String userId;
    private String createDate;
    private String updateDate;

    public SeatResponseDto(Seat seat) {
        this.orderNum = seat.getOrderNum();
        this.totalPrice = seat.getTotalPrice();
        this.userId = seat.getUserId();
        this.createDate = String.valueOf(seat.getCreateDate());
        this.updateDate = String.valueOf(seat.getUpdateDate());
    }
}
