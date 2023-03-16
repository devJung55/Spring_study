package com.example.ex02.mapper;

import com.example.ex02.domain.dto.OrderDTO;
import com.example.ex02.domain.vo.OrderVO;
import com.example.ex02.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class OrderMapperTests {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Test
    public void insertTest(){
        ProductVO productVO = null;
        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(2L);
        orderVO.setProductCount(10);

        productVO = productMapper.select(orderVO.getProductId());
        productVO.setProductStock(productVO.getProductStock() - orderVO.getProductCount());

        orderMapper.insert(orderVO);
        productMapper.update(productVO);
    }

    @Test
    public void deleteTest(){
        OrderDTO orderDTO = orderMapper.select(1L);
        ProductVO productVO = productMapper.select(orderDTO.getProductId());
        productVO.setProductStock(productVO.getProductStock() + orderDTO.getProductCount());

        orderMapper.delete(1L);
        productMapper.update(productVO);
    }

    @Test
    public void selectAllTest(){
        assertThat(orderMapper.selectAll().get(0).getOrderPrice()).isEqualTo(20000);
    }
}
