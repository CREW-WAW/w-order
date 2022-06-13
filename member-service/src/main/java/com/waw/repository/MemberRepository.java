package com.waw.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.waw.domain.Member;

@Component
public class MemberRepository {

	public Member get(long idx) {
		return Member.builder()
				.name("name")
				.birthDay(LocalDate.now())
				.idx(idx)
				.loginId("loginId")
				.phoneNumber("01012341234")
				.build();
	}
	
	public void save(Member member) {
		
	}
}
