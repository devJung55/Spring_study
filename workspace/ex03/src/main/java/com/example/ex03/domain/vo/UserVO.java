package com.example.ex03.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long userId;
    private Long orderId;
    private String userName;
}
