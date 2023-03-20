package com.example.ex03.domain.dao;

import com.example.ex03.domain.dto.OrderDTO;
import com.example.ex03.domain.vo.OrderVO;
import com.example.ex03.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;

//    추가
    public void save(OrderVO orderVO){
        orderMapper.insert(orderVO);
    }
//    삭제
    public void delete(Long orderId){
        orderMapper.delete(orderId);
    }
//    조회(총 결제 금액까지)
    public OrderDTO findById(Long orderId){
        return orderMapper.select(orderId);
    }
//    목록(총 결제 금액까지)
    public List<OrderDTO> findAll(){
        return orderMapper.selectAll();
    }
}

















