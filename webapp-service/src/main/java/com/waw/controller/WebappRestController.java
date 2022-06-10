package com.waw.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebappRestController {
	
	private static final Logger logger = LogManager.getLogger(WebappRestController.class);

	@GetMapping("/info")
	public ResponseEntity<?> getWebapp() {
		logger.info("getWebapp start");
		logger.info("getWebapp end");
		return ResponseEntity.ok("return Webapp.");
	}
}
