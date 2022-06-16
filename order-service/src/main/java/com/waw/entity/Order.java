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
    private Long id;

    private String productName;
    private String type;
    private int price;
    private LocalDateTime createDate = LocalDateTime.now();

    @Builder
    public Order(OrderRequestDto orderDto) {
        this.productName = orderDto.getProductName();
        this.type = orderDto.getType();
        this.price = orderDto.getPrice();
    }
}
