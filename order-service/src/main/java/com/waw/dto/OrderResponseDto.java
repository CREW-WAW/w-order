package com.waw.dto;

import com.waw.entity.Order;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderResponseDto {

    private Long orderNum;
    private Long totalPrice;
    private String userId;
    private String createDate;
    private String updateDate;

    public OrderResponseDto(Order order) {
        this.orderNum = order.getOrderNum();
        this.totalPrice = order.getTotalPrice();
        this.userId = order.getUserId();
        this.createDate = String.valueOf(order.getCreateDate());
        this.updateDate = String.valueOf(order.getUpdateDate());
    }
}
