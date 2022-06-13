package com.waw.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.waw.domain.Member;
import com.waw.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;

	public Member get(long idx) {
		return Member.builder()
				.name("name")
				.birthDay(LocalDate.now())
				.idx(idx)
				.loginId("loginId")
				.phoneNumber("01012341234")
				.build();
	}
	
	// @Transactional
	public void save(Member member) {
		// memberRepository.save(member);
	}
	
}
