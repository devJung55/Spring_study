package com.example.ex02.mapper;

import com.example.ex02.domain.dto.OrderDTO;
import com.example.ex02.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
//    추가
    public void insert(OrderVO orderVO);

//    삭제
    public void delete(Long orderId);

//    조회(총 결제 금액까지)
    public OrderDTO select(Long orderId);

//    목록(총 결제 금액까지)
    public List<OrderDTO> selectAll();
}
