package com.waw.controller;

import com.waw.common.ApiResponseDto;
import com.waw.dto.OrderRequestDto;
import com.waw.dto.OrderResponseDto;
import com.waw.entity.Order;
import com.waw.service.OrderService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

	private static final Logger logger = LogManager.getLogger(OrderRestController.class);

	private final OrderService service;

	public OrderRestController(OrderService service) {
		this.service = service;
	}

	@GetMapping("/info")
	public ResponseEntity<?> getOrder() {
		logger.info("getOrder start");
		logger.info("getOrder end");
		return ResponseEntity.ok("return Order.");
	}

	@PostMapping("/insert")
	public int insertOrder(@RequestBody OrderRequestDto request) {
		return service.insertOrderData(Order.builder().orderDto(request).build());
	}

	@GetMapping("/get/{idx}")
	public ApiResponseDto<Object> getOrder(@PathVariable String idx) {
		OrderResponseDto responseData =  service.selectOrder(idx == null ? "0" : idx);
		return new ApiResponseDto<>(responseData);
	}

	@GetMapping("/list")
	public ApiResponseDto<Object> getOrderList(String searchType, String searchParam) {
		List<OrderResponseDto> responseData =  service.selectOrderList(
				searchType == null ? "" : searchType, searchParam == null ? "" : searchParam);

		logger.info("searchType :: {}, searchValue :: {}", searchType, searchParam);
		return new ApiResponseDto<>(responseData);
	}
}




