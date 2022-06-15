package com.waw.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.waw.dto.ProductResponseDto;
import com.waw.entity.Product;
import com.waw.entity.ProductRepository;
import com.waw.entity.QProduct;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private EntityManager em;

    @Autowired
    private ProductRepository repo;

    static private QProduct qProduct = QProduct.product;

    @Transactional
    public int insertProductData(Product product) {
        repo.save(product);
        return 1;
    }

    public ProductResponseDto selectProduct(String idx) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return new ProductResponseDto(
            queryFactory.selectFrom(qProduct).where(qProduct.id.eq(Long.valueOf(idx))).fetchOne());
    }

    public List<ProductResponseDto> selectProductList(String type, String param) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory.selectFrom(qProduct).fetch().stream()
            .map(p -> new ProductResponseDto(p)).collect(Collectors.toList());
    }
}
