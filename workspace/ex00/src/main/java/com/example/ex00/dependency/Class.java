package com.example.ex00.dependency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class Class {
    private final Teacher teacher;
    private List<Student> students;
}
