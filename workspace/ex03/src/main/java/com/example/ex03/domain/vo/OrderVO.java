package com.example.ex03.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long orderId;
    private Long productId;
    private Integer productCount;
    private String orderDate;
}
