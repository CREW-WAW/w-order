package com.waw.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.waw.dto.ProductRequestDto;
import com.waw.dto.ProductResponseDto;
import com.waw.entity.Product;
import com.waw.entity.ProductRepository;
import com.waw.exception.ErrorCode;
import com.waw.exception.ProductDataException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.waw.entity.QProduct.*;

@Slf4j
@Service
public class ProductService {

    private final JPAQueryFactory queryFactory;
    private final ProductRepository repo;

    public ProductService(EntityManager em, ProductRepository repo) {
        this.queryFactory = new JPAQueryFactory(em);
        this.repo = repo;
    }

    public ProductResponseDto selectProduct(String idx) {
        Optional<Product> targetProduct = Optional.ofNullable(queryFactory.selectFrom(product)
            .where(product.useYn.eq("Y").and(product.idx.eq(Long.valueOf(idx))))
            .fetchOne());

        if (targetProduct.isEmpty()) {
            throw new ProductDataException(ErrorCode.PRODUCT_NO_TARGET);
        }

        return new ProductResponseDto(targetProduct.get());
    }

    public List<ProductResponseDto> selectProductList(String searchType, String searchParam) {
        BooleanBuilder builder = new BooleanBuilder().and(product.useYn.eq("Y"));

        switch (searchType) {
            case "type":
                builder.and(product.type.eq(searchParam));
                break;
            case "price":
                try {
                    builder.and(product.price.loe(Integer.valueOf(searchParam)));
                } catch (NumberFormatException e) {
                    throw new ProductDataException(ErrorCode.COMMON_CHECK_PARAMETER);
                }
                break;
        }

        List<ProductResponseDto> productList = queryFactory.selectFrom(product).where(builder)
            .fetch().stream()
            .map(ProductResponseDto::new).collect(Collectors.toList());

        if (productList.size() == 0) {
            throw new ProductDataException(ErrorCode.PRODUCT_NOT_EXIST_LIST);
        }

        return productList;
    }

    @Transactional
    public ProductResponseDto insertProductData(ProductRequestDto dto) {
        Product resProduct = repo.save(Product.builder().productDto(dto).build());

        return new ProductResponseDto(resProduct);
    }

    @Transactional
    public ProductResponseDto updateProductData(String idx, ProductRequestDto dto) {
        System.out.println("0000");
        Optional<Product> targetProduct = repo.findById(Long.valueOf(idx));
        System.out.println("1111");

        if (targetProduct.isEmpty()) {
            throw new ProductDataException(ErrorCode.PRODUCT_NO_TARGET);
        }

        Product targetProductObj = Product.builder().productDto(dto).build();
        Product resProduct = repo.save(targetProductObj);

        return new ProductResponseDto(resProduct);
    }

    @Transactional
    public boolean deleteProductData(String idx) {
        Optional<Product> targetProduct = repo.findById(Long.valueOf(idx));

        if (targetProduct.isEmpty()) {
            throw new ProductDataException(ErrorCode.PRODUCT_NO_TARGET);
        }

        targetProduct.get().setUseYn("N");
        repo.save(targetProduct.get());

        return true;
    }
}
