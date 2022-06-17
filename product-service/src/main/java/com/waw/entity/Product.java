package com.waw.entity;

import com.waw.dto.ProductRequestDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Long idx;

    private String productName;
    private String productContent;
    private String type;
    private int price;

    private String useYn = "Y";
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    @Builder
    public Product(ProductRequestDto productDto) {
        this.productName = productDto.getProductName();
        this.productContent = productDto.getProductContent();
        this.type = productDto.getType();
        this.price = productDto.getPrice();
    }
}
