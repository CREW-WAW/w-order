package com.waw.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
	
	private static final Logger logger = LogManager.getLogger(MemberRestController.class);

	@GetMapping("/info")
	public String getMember() {
		logger.info("getMember start");
		logger.info("getMember end");
		return "return Member.";
	}
}
