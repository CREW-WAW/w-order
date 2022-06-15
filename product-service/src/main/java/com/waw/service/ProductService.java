package com.waw.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
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
    public int insertProductData(Product product) {
        repo.save(product);
        return 1;
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

        return queryFactory.selectFrom(product).fetch().stream()
            .map(ProductResponseDto::new).collect(Collectors.toList());
    }
}
