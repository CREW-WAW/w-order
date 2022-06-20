package com.waw.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.waw.common.ApiResponseDto;
import com.waw.dto.OrderRequestDto;
import com.waw.dto.OrderResponseDto;
import com.waw.entity.Order;
import com.waw.entity.OrderRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
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

    public OrderResponseDto selectOrder(String idx) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return new OrderResponseDto(
            Objects.requireNonNull(
                queryFactory.selectFrom(order).where(order.orderNum.eq(Long.valueOf(idx)))
                    .fetchOne()));
    }

    public List<OrderResponseDto> selectOrderList(String type, String param) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory.selectFrom(order).fetch().stream()
            .map(OrderResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public OrderResponseDto insertOrderData(OrderRequestDto order,int idx) {
        order.setOrderNum(idx);
        if(repo.findById(Long.valueOf(idx)).isPresent()){
            return null;
        } else {
           Order resOrder = repo.save(Order.builder().orderDto(order).build());
           return new OrderResponseDto(resOrder);
        }
    }

    @Transactional
    public String deleteOrderData(int idx){
        String result = "";
        if(repo.findById(Long.valueOf(idx)).isPresent()){
            Order findOrder = repo.findById(Long.valueOf(idx)).get();
            repo.delete(findOrder);
            result = "성공";
        } else {
            result = "실패";
        }
        return result;
    }

   /* @Transactional
    public void updateOrderData(OrderRequestDto order, int idx){
        Order findOrder = repo.findById(Long.valueOf(idx)).get();
        repo.delete(findOrder);
    }*/

}
