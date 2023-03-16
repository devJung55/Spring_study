package com.example.ex02.service;

import com.example.ex02.domain.dao.OrderDAO;
import com.example.ex02.domain.dao.ProductDAO;
import com.example.ex02.domain.dto.OrderDTO;
import com.example.ex02.domain.vo.OrderVO;
import com.example.ex02.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;

//    추가
    @Transactional(rollbackFor = Exception.class)
    public void order(OrderVO orderVO){
        ProductVO productVO = productDAO.findById(orderVO.getProductId());
        productVO.setProductStock(productVO.getProductStock() - orderVO.getProductCount());
        productDAO.setProductVO(productVO);
        orderDAO.save(orderVO);
    }

//    삭제
    @Transactional(rollbackFor = Exception.class)
    public void cancel(Long orderId){
        ProductVO productVO = productDAO.findById(orderId);
        OrderDTO orderDTO = orderDAO.findById(orderId);
        productVO.setProductStock(productVO.getProductStock() + orderDTO.getProductCount());
        productDAO.setProductVO(productVO);
        orderDAO.deleteById(orderId);
    }

//    조회(총 결제 금액까지)
    public OrderDTO getOrder(Long orderId){
        return orderDAO.findById(orderId);
    }

//    목록(총 결제 금액까지)
    public List<OrderDTO> getList(){
        return orderDAO.findAll();
    }
}



























