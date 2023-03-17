package com.example.ex03.controller;

import com.example.ex03.domain.vo.ProductVO;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

//    등록 완료
    @PostMapping("/register/products")
    public void register(ProductVO productVO) {
        log.info(productVO.toString());

        productService.registerProduct(productVO);
    }

//    수정 완료
    @PutMapping("/update/products")
    public void updateAll(ProductVO productVO) {
        productVO.setProductName("크림땅콩");

        log.info(productVO.toString());

        productService.updateProduct(productVO);
    }

//    상세보기
    @GetMapping("/detail/products/{productId}")
    public void detail(@PathVariable("productId") Long productId) {
        log.info(productService.getProduct(productId).toString());
    }

//    목록
    @GetMapping("/list/products")
    public void findAll() {
        log.info(productService.getList().toString());
    }
}
