package com.waw.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.waw.dto.ProductRequestDto;
import com.waw.dto.ProductResponseDto;
import com.waw.entity.Product;
import com.waw.entity.ProductRepository;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.waw.entity.QProduct.*;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@Slf4j
@Service
public class ProductService {

    private final EntityManager em;
    private final ProductRepository repo;

    public ProductService(EntityManager em, ProductRepository repo) {
        this.em = em;
        this.repo = repo;
    }

    public ProductResponseDto selectProduct(String idx) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return new ProductResponseDto(
            Objects.requireNonNull(
                queryFactory.selectFrom(product).where(product.useYn.eq("Y").and(product.id.eq(Long.valueOf(idx))))
                    .fetchOne()));
    }

    public List<ProductResponseDto> selectProductList(String searchType, String searchParam) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        BooleanBuilder builder = new BooleanBuilder().and(product.useYn.eq("Y"));

        switch (searchType) {
            case "type":
                builder.and(product.type.eq(searchParam));
                break;
            case "price":
                try {
                    builder.and(product.price.loe(Integer.valueOf(searchParam)));
                } catch (NumberFormatException e) {
                    log.error("Error, Price 값 확인");
                }
                break;
        }

        return queryFactory.selectFrom(product).where(builder).fetch().stream()
            .map(ProductResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ProductResponseDto insertProductData(ProductRequestDto dto) {
        Product resProduct = repo.save(Product.builder().productDto(dto).build());

        return new ProductResponseDto(resProduct);
    }

    @Transactional
    public ProductResponseDto updateProductData(String idx, ProductRequestDto dto) {
        Product targetProduct = Product.builder().productDto(dto).build();
        targetProduct.setId(Long.valueOf(idx));

        Product resProduct = repo.save(targetProduct);

        return new ProductResponseDto(resProduct);
    }

    @Transactional
    public ProductResponseDto deleteProductData(String idx) {
        Product targetProduct = repo.findById(Long.valueOf(idx)).get();
        targetProduct.setUseYn("N");

        Product resProduct = repo.save(targetProduct);

        return new ProductResponseDto(resProduct);
    }
}
