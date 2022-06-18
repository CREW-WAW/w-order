package com.waw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequestDto {

	private String loginId;
	private String birthDay;
	private String phoneNumber;
	private String name;
}
