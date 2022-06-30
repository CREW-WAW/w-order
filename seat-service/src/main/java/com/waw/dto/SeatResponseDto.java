package com.waw.dto;

import com.waw.entity.Seat;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SeatResponseDto {

    private Long seatNum;
    private String ownerId;
    private String tableNm;
    private String LimitPer;
    private String useYn;
    private String status;
    private String createDate;
    private String updateDate;


    public SeatResponseDto(Seat seat) {
        this.seatNum = seat.getSeatNum();
        this.ownerId = seat.getOwnerId();
        this.tableNm = seat.getTableNm();
        this.LimitPer = seat.getLimitPer();
        this.useYn = seat.getUseYn();
        this.status = seat.getStatus();
        this.createDate = String.valueOf(seat.getCreateDate());
        this.updateDate = String.valueOf(seat.getUpdateDate());
    }
}
