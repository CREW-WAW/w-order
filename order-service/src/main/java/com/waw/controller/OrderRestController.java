package com.waw.controller;

import com.waw.exception.ApiResponseDto;
import com.waw.dto.OrderRequestDto;
import com.waw.dto.OrderResponseDto;
import com.waw.entity.Order;
import com.waw.service.OrderService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("/deleteOrder/{idx}")
	public String deleteOrder(@PathVariable int idx){
		return service.deleteOrderData(idx);
	}

	@PostMapping("/insertOrder/{idx}")
	public ApiResponseDto insertOrder(@RequestBody OrderRequestDto request, @PathVariable int idx) {
		return new ApiResponseDto(service.insertOrderData(request,idx));
	}

	@PutMapping("/updateOrder/{idx}")
	public ApiResponseDto updateOrder(@RequestBody OrderRequestDto request, @PathVariable int idx) {
		return new ApiResponseDto(service.updateOrderData(request,idx));
	}
}




