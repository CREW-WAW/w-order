package com.waw.entity;

import com.waw.dto.ProductRequestDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TB_PRODUCT")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String type;
    private int price;
    private LocalDateTime createDate = LocalDateTime.now();

    @Builder
    public Product(ProductRequestDto productDto) {
        this.productName = productDto.getProductName();
        this.type = productDto.getType();
        this.price = productDto.getPrice();
    }
}
