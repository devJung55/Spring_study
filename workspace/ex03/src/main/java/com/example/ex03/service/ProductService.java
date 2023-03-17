package com.example.ex03.service;

import com.example.ex03.domain.dao.ProductDAO;
import com.example.ex03.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    //    상품 추가
    public void registerProduct(ProductVO productVO){
        productDAO.save(productVO);
    }

    //    상품 수정
    public void updateProduct(ProductVO productVO){
        productDAO.setProductVO(productVO);
    }

    //    상품 목록
    public List<ProductVO> getList(){
        return productDAO.findAll();
    }

    //    상품 조회
    public ProductVO getProduct(Long productId){
        return productDAO.findById(productId);
    }
}
