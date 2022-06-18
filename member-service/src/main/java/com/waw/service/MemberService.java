package com.waw.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.waw.domain.Member;
import com.waw.dto.MemberRequestDto;
import com.waw.dto.MemberResponseDto;
import com.waw.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final EntityManager em;

	public MemberResponseDto get(final long idx) {
		Optional<Member> opMember = memberRepository.findById(idx);
		if (opMember.isPresent()) {
			return new MemberResponseDto(opMember.get());
		}
		return null;
	}
	
	@Transactional
	public MemberResponseDto save(MemberRequestDto memberDto) {
		Member member = memberRepository.save(Member.builder()
				.birthDay(memberDto.getBirthDay())
				.loginId(memberDto.getLoginId())
				.name(memberDto.getName())
				.phoneNumber(memberDto.getPhoneNumber())
				.build());
		
		return new MemberResponseDto(member);
	}
	
}
