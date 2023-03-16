package com.example.ex02.domain.dao;

import com.example.ex02.domain.vo.ProductVO;
import com.example.ex02.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    //    상품 추가
    public void save(ProductVO productVO){
        productMapper.insert(productVO);
    }
    //    상품 수정
    public void setProductVO(ProductVO productVO){
        productMapper.update(productVO);
    }
    //    상품 목록
    public List<ProductVO> findAll(){
        return productMapper.selectAll();
    }
    //    상품 조회
    public ProductVO findById(Long productId){
        return productMapper.select(productId);
    }
}









