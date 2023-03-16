package com.example.ex02.service;

import com.example.ex02.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    //    상품 추가
    public void registerProduct(ProductVO productVO);
    //    상품 수정
    public void updateProduct(ProductVO productVO);
    //    상품 목록
    public List<ProductVO> getList();
    //    상품 조회
    public ProductVO getProduct(Long productId);
}
