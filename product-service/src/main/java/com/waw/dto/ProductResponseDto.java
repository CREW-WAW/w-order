package com.waw.dto;

import com.waw.entity.Product;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductResponseDto {

    private Long productIdx;
    private String productName;
    private String productContent;
    private String type;
    private int price;

    public ProductResponseDto(Product product) {
        this.productIdx = product.getIdx();
        this.productName = product.getProductName();
        this.productContent = product.getProductContent();
        this.type = product.getType();
        this.price = product.getPrice();
    }
}
