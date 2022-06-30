package com.waw.entity;

import com.waw.dto.SeatRequestDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "TB_SEAT")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatNum;
    private String ownerId;
    private String tableNm;
    private String LimitPer;
    private String useYn;
    private String status;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    @Builder
    public Seat(SeatRequestDto seatDto) {
        this.seatNum = seatDto.getSeatNum();
        this.ownerId = seatDto.getOwnerId();
        this.tableNm = seatDto.getTableNm();
        this.LimitPer = seatDto.getLimitPer();
        this.useYn = seatDto.getUseYn();
        this.status = seatDto.getStatus();
    }

}
