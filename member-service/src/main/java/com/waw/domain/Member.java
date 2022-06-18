package com.waw.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.waw.dto.MemberRequestDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TB_MEMBER")
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	private String loginId;
	private LocalDate birthDay;
	private String phoneNumber;
	private String name;
	 
	@Builder
    public Member(MemberRequestDto memberDto) {
        this.loginId = memberDto.getLoginId();
        this.birthDay = memberDto.getBirthDay();
        this.phoneNumber = memberDto.getPhoneNumber();
        this.name = memberDto.getName();
    }
}
