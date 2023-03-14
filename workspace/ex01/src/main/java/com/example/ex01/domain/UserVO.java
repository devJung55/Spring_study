package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Data
public class UserVO {
    private String userId;
    private String userPassword;
}
