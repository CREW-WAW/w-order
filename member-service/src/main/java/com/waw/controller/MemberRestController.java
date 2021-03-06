package com.waw.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waw.common.ApiResponseDto;
import com.waw.dto.MemberRequestDto;
import com.waw.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController("/api")
public class MemberRestController {
	
	private final MemberService memberService;
	
	private static final Logger logger = LogManager.getLogger(MemberRestController.class);

	@GetMapping("/info/{idx}")
	public ApiResponseDto<?> get(@PathVariable("idx") long idx) {
		return new ApiResponseDto<>(memberService.get(idx));
	}
	
	@PostMapping("/save")
	public ApiResponseDto<?> save(MemberRequestDto member) {
		return new ApiResponseDto<>(memberService.save(member));
	}
}
