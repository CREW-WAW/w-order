package com.waw.controller;

import com.waw.common.ApiResponseDto;
import com.waw.dto.ProductRequestDto;
import com.waw.dto.ProductResponseDto;
import com.waw.service.ProductService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

	private static final Logger logger = LogManager.getLogger(ProductRestController.class);

	private final ProductService service;

	public ProductRestController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/info")
	public ResponseEntity<?> getProduct() {
		logger.info("getProduct start");
		logger.info("getProduct end");
		return ResponseEntity.ok("return product.");
	}

	@GetMapping("/get/{idx}")
	public ApiResponseDto<Object> getProduct(@PathVariable String idx) {
		ProductResponseDto responseData =  service.selectProduct(idx == null ? "0" : idx);

		return new ApiResponseDto<>(responseData);
	}

	@GetMapping("/list")
	public ApiResponseDto<Object> getProductList(String searchType, String searchParam) {
		List<ProductResponseDto> responseData =  service.selectProductList(
			searchType == null ? "" : searchType,
			searchParam == null ? "" : searchParam);

		return new ApiResponseDto<>(responseData);
	}

	@PostMapping("/insert")
	public ApiResponseDto<Object> insertProduct(@RequestBody ProductRequestDto request) {

		return new ApiResponseDto<>(service.insertProductData(request));
	}

	@PutMapping("/update/{idx}")
	public ApiResponseDto<Object> updateProduct(@PathVariable String idx, @RequestBody ProductRequestDto request) {

		return new ApiResponseDto<>(service.updateProductData(idx, request));
	}

	@DeleteMapping("/delete/{idx}")
	public ApiResponseDto<Object> deleteProduct(@PathVariable String idx) {

		return new ApiResponseDto<>(service.deleteProductData(idx));
	}
}




