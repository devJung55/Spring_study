package com.example.ex03.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long productId;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
}
