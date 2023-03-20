package com.example.ex03.controller;

import com.example.ex03.domain.vo.ProductVO;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/products/*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    상품 추가
    @PostMapping("write")
    public void write(@RequestBody ProductVO productVO){
        productService.write(productVO);
    }

//    상품 수정
    @PatchMapping("update")
    public void update(@RequestBody ProductVO productVO){
        productService.modify(productVO);
    }

//    상품 목록
    @GetMapping("list")
    public List<ProductVO> showList(){
        return productService.getList();
    }

//    상품 조회
    @GetMapping("{productId}")
    public ProductVO getProduct(@PathVariable("productId") Long productId) {
        return productService.getProduct(productId);
    }
}
















