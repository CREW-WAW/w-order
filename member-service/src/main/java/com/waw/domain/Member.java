package com.waw.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class Member {

	private long idx;
	
	private String loginId;
	
	private LocalDate birthDay;
	
	private String phoneNumber;
	
	private String name;
}
