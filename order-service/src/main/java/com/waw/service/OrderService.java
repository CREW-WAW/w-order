package com.waw.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.waw.dto.OrderResponseDto;
import com.waw.entity.OrderRepository;
import com.waw.entity.Order;
import com.waw.entity.OrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.waw.entity.QOrder.*;

@Service
public class OrderService {

    private final EntityManager em;
    private final OrderRepository repo;

    public OrderService(EntityManager em, OrderRepository repo) {
        this.em = em;
        this.repo = repo;
    }

    @Transactional
    public int insertOrderData(Order order) {
        repo.save(order);
        return 1;
    }

    public OrderResponseDto selectOrder(String idx) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return new OrderResponseDto(
            Objects.requireNonNull(
                queryFactory.selectFrom(order).where(order.id.eq(Long.valueOf(idx)))
                    .fetchOne()));
    }

    public List<OrderResponseDto> selectOrderList(String type, String param) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory.selectFrom(order).fetch().stream()
            .map(OrderResponseDto::new).collect(Collectors.toList());
    }
}
