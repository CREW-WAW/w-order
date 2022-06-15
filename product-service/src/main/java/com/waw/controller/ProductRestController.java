package com.waw.controller;

import com.waw.common.ApiResponseDto;
import com.waw.dto.ProductRequestDto;
import com.waw.dto.ProductResponseDto;
import com.waw.entity.Product;
import com.waw.service.ProductService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	private static final Logger logger = LogManager.getLogger(ProductRestController.class);

	@Autowired
	private ProductService service;

	@GetMapping("/info")
	public ResponseEntity<?> getProduct() {
		logger.info("getProduct start");
		logger.info("getProduct end");
		return ResponseEntity.ok("return product.");
	}

	@PostMapping("/insert")
	public int insertProduct(@RequestBody ProductRequestDto request) {
		return service.insertProductData(Product.builder().productDto(request).build());
	}

	@GetMapping("/get/{idx}")
	public ApiResponseDto getProduct(@PathVariable String idx) {
		ProductResponseDto responseData =  service.selectProduct(idx == null ? "0" : idx);
		return new ApiResponseDto<>(responseData);
	}

	@GetMapping("/list")
	public ApiResponseDto getProductList(String searchType, String searchParam) {
		List<ProductResponseDto> responseDatas =  service.selectProductList(
			searchType == null ? "" : searchType, searchParam == null ? "" : searchParam);

		logger.info("searchType :: {}, searchValue :: {}", searchType, searchParam);
		return new ApiResponseDto<>(responseDatas);
	}
}




