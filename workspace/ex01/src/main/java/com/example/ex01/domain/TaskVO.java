package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TaskVO {
    private Integer number;
    private Integer korea;
    private Integer english;
    private Integer math;
}
