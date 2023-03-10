package com.example.ex00.dependency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Student {
    private final Teacher teacher;
    private final School school;
}
