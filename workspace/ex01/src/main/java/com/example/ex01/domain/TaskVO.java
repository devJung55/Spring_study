package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private Integer num;
    private Integer kor;
    private Integer eng;
    private Integer math;

    public Integer getTotal(){
        return kor + eng + math;
    }

    public Double getAverage() {
        return getTotal() / 3.0;
    }
}
