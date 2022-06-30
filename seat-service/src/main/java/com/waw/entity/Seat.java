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
    private long orderNum;
    private long totalPrice;
    private String userId;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    @Builder
    public Seat(SeatRequestDto seatDto) {
        this.orderNum = seatDto.getOrderNum();
        this.totalPrice = seatDto.getTotalPrice();
        this.userId = seatDto.getUserId();
    }

}
