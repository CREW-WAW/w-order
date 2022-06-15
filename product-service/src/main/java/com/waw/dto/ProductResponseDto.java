package com.waw.dto;

import com.waw.entity.Product;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductResponseDto {

    private Long productId;
    private String productName;
    private String type;
    private int price;

    public ProductResponseDto(Product product) {
        this.productId = product.getId();
        this.productName = product.getProductName();
        this.type = product.getType();
        this.price = product.getPrice();
    }
}
