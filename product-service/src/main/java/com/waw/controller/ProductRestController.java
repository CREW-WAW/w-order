package com.waw.controller;

import com.waw.dto.ApiResponseDto;
import com.waw.dto.ProductRequestDto;
import com.waw.dto.ProductResponseDto;
import com.waw.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService service;

    @GetMapping("/info")
    public ResponseEntity<?> getProduct() {
        log.info("getProduct start");
        log.info("getProduct end");
        return ResponseEntity.ok("return product.");
    }

    @GetMapping("/get/{idx}")
    public ResponseEntity<ApiResponseDto<Object>> getProduct(@PathVariable String idx) {
        ProductResponseDto responseData = service.selectProduct(idx == null ? "0" : idx);

        return new ResponseEntity<>(new ApiResponseDto<>(responseData), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<Object>> getProductList(String searchType,
        String searchParam) {
        List<ProductResponseDto> responseData = service.selectProductList(
            searchType == null ? "" : searchType,
            searchParam == null ? "" : searchParam);

        return new ResponseEntity<>(new ApiResponseDto<>(responseData), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<ApiResponseDto<Object>> insertProduct(
        @RequestBody ProductRequestDto request) {

        return new ResponseEntity<>(new ApiResponseDto<>(service.insertProductData(request)),
            HttpStatus.OK);
    }

    @PutMapping("/update/{idx}")
    public ResponseEntity<ApiResponseDto<Object>> updateProduct(@PathVariable String idx,
        @RequestBody ProductRequestDto request) {

        return new ResponseEntity<>(new ApiResponseDto<>(service.updateProductData(idx, request)),
            HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<ApiResponseDto<Object>> deleteProduct(@PathVariable String idx) {

        return new ResponseEntity<>(new ApiResponseDto<>(service.deleteProductData(idx)),
            HttpStatus.OK);
    }
}




