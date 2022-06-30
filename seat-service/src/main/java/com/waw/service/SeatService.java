package com.waw.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.waw.dto.SeatRequestDto;
import com.waw.dto.SeatResponseDto;
import com.waw.entity.Seat;
import com.waw.entity.SeatRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.waw.entity.QSeat.*;

@Service
public class SeatService {

    private final EntityManager em;
    private final SeatRepository repo;

    public SeatService(EntityManager em, SeatRepository repo) {
        this.em = em;
        this.repo = repo;
    }

    public SeatResponseDto selectSeat(String idx) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return new SeatResponseDto(
            Objects.requireNonNull(
                queryFactory.selectFrom(seat).where(seat.orderNum.eq(Long.valueOf(idx)))
                    .fetchOne()));
    }

    public List<SeatResponseDto> selectSeatList(String type, String param) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory.selectFrom(seat).fetch().stream()
            .map(SeatResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public SeatResponseDto insertSeatData(SeatRequestDto seat,int idx) {
        seat.setOrderNum(idx);
        if(repo.findById(Long.valueOf(idx)).isPresent()){
            return null;
        } else {
           Seat resSeat = repo.save(Seat.builder().seatDto(seat).build());
           return new SeatResponseDto(resSeat);
        }
    }

    @Transactional
    public String deleteSeatData(int idx) {
        String result = "";
        if(repo.findById(Long.valueOf(idx)).isPresent()){
            Seat findSeat = repo.findById(Long.valueOf(idx)).get();
            repo.delete(findSeat);
            result = "성공";
        } else {
            result = "실패";
        }
        return result;
    }

    @Transactional
    public SeatResponseDto updateSeatData(SeatRequestDto seat, int idx) {
        seat.setOrderNum(idx);
        if(repo.findById(Long.valueOf(idx)).isPresent()){
            Seat resSeat = repo.save(Seat.builder().seatDto(seat).build());
            return new SeatResponseDto(resSeat);
        } else {
            return null;
        }
    }

}
