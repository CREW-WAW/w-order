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
import org.springframework.stereotype.Service;

import static com.waw.entity.QProduct.*;

@Service
public class ProductService {

    private final EntityManager em;
    private final ProductRepository repo;

    public ProductService(EntityManager em, ProductRepository repo) {
        this.em = em;
        this.repo = repo;
    }

    @Transactional
    public ProductResponseDto insertProductData(ProductRequestDto dto) {
        Product resProduct = repo.save(Product.builder().productDto(dto).build());

        return new ProductResponseDto(resProduct);
    }

    public ProductResponseDto selectProduct(String idx) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return new ProductResponseDto(
            Objects.requireNonNull(
                queryFactory.selectFrom(product).where(product.id.eq(Long.valueOf(idx)))
                    .fetchOne()));
    }

    public List<ProductResponseDto> selectProductList(String type, String param) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        BooleanBuilder builder = new BooleanBuilder();

        switch (type) {
            case "type":
                builder.and(product.type.eq(param));
            case "price":
                builder.and(product.price.loe(Integer.valueOf(param)));
        }

        return queryFactory.selectFrom(product).where(builder).fetch().stream()
            .map(ProductResponseDto::new).collect(Collectors.toList());
    }
}
