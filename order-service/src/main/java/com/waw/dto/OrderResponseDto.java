package com.waw.dto;

import com.waw.entity.Order;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderResponseDto {

    private Long productId;
    private String productName;
    private String type;
    private int price;

    public OrderResponseDto(Order order) {
        this.productId = order.getId();
        this.productName = order.getProductName();
        this.type = order.getType();
        this.price = order.getPrice();
    }
}
