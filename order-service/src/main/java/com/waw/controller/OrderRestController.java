package com.waw.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
	
	private static final Logger logger = LogManager.getLogger(OrderRestController.class);

	@GetMapping("/info")
	public String getOrder() {
		logger.info("getOrder start");
		logger.info("getOrder end");
		return "return order.";
	}
}
