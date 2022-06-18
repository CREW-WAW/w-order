package com.waw.dto;

import java.time.LocalDate;

import com.waw.domain.Member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberResponseDto {

	private long idx;
	private String loginId;
	private LocalDate birthDay;
	private String phoneNumber;
	private String name;
	
	public MemberResponseDto(Member member) {
		this.idx = member.getIdx();
		this.loginId = member.getLoginId();
		this.birthDay = member.getBirthDay();
		this.phoneNumber = member.getPhoneNumber();
		this.name = member.getName();
	}
}
