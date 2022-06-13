package com.waw.service;

import org.springframework.stereotype.Service;

import com.waw.domain.Member;
import com.waw.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;

	public Member get(long idx) {
		return memberRepository.get(idx);
	}
	
	// @Transactional
	public void save(Member member) {
		memberRepository.save(member);
	}
	
}
