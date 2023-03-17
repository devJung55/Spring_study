package com.example.ex03.mapper;

import com.example.ex03.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
//    상품 추가
    public void insert(ProductVO productVO);
//    상품 수정
    public void update(ProductVO productVO);
//    상품 목록
    public List<ProductVO> selectAll();
//    상품 조회
    public ProductVO select(Long productId);
}
