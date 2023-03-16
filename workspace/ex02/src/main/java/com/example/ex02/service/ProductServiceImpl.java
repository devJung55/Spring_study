package com.example.ex02.service;

import com.example.ex02.domain.dao.ProductDAO;
import com.example.ex02.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Qualifier("product") @Primary
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public void registerProduct(ProductVO productVO) {
        productDAO.save(productVO);
    }

    @Override
    public void updateProduct(ProductVO productVO) {
        productDAO.setProductVO(productVO);
    }

    @Override
    public List<ProductVO> getList() {
        return productDAO.findAll();
    }

    @Override
    public ProductVO getProduct(Long productId) {
        return productDAO.findById(productId);
    }
}
