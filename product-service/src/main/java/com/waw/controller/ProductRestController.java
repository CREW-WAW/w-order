package com.waw.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	private static final Logger logger = LogManager.getLogger(ProductRestController.class);

	@GetMapping("/info")
	public String getProduct() {
		logger.info("getProduct start");
		logger.info("getProduct end");
		return "return product.";
	}
}
