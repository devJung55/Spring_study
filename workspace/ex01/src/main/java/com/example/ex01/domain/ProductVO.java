package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductVO {
    private String name;
    private Integer price;
    private Integer stock;
    private String brand;
}
