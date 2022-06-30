package com.waw.controller;

import com.waw.common.ApiResponseDto;
import com.waw.dto.SeatRequestDto;
import com.waw.dto.SeatResponseDto;
import com.waw.service.SeatService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeatRestController {

	private static final Logger logger = LogManager.getLogger(SeatRestController.class);

	private final SeatService service;

	public SeatRestController(SeatService service) {
		this.service = service;
	}

	@GetMapping("/info")
	public ResponseEntity<?> getSeat() {
		logger.info("getSeat start");
		logger.info("getSeat end");
		return ResponseEntity.ok("return Seat.");
	}

	@GetMapping("/get/{idx}")
	public ApiResponseDto<Object> getSeat(@PathVariable String idx) {
		SeatResponseDto responseData =  service.selectSeat(idx == null ? "0" : idx);
		return new ApiResponseDto<>(responseData);
	}

	@GetMapping("/list")
	public ApiResponseDto<Object> getSeatList(String searchType, String searchParam) {
		List<SeatResponseDto> responseData =  service.selectSeatList(
				searchType == null ? "" : searchType, searchParam == null ? "" : searchParam);

		logger.info("searchType :: {}, searchValue :: {}", searchType, searchParam);
		return new ApiResponseDto<>(responseData);
	}

	@DeleteMapping("/deleteSeat/{idx}")
	public String deleteSeat(@PathVariable long idx){
		return service.deleteSeatData(idx);
	}

	@PostMapping("/insertSeat/{idx}")
	public ApiResponseDto insertSeat(@RequestBody SeatRequestDto request, @PathVariable long idx) {
		return new ApiResponseDto(service.insertSeatData(request,idx));
	}

	@PutMapping("/updateSeat/{idx}")
	public ApiResponseDto updateSeat(@RequestBody SeatRequestDto request, @PathVariable long idx) {
		return new ApiResponseDto(service.updateSeatData(request,idx));
	}
}




