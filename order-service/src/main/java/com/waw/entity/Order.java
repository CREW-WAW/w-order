package com.waw.entity;

import com.waw.dto.OrderRequestDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "TB_ORDER")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNum;
    private long totalPrice;
    private String userId;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    @Builder
    public Order(OrderRequestDto orderDto) {
        this.orderNum = orderDto.getOrderNum();
        this.totalPrice = orderDto.getTotalPrice();
        this.userId = orderDto.getUserId();
    }

}
