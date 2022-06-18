package com.waw.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequestDto {

	private String loginId;
	private LocalDate birthDay;
	private String phoneNumber;
	private String name;
}
