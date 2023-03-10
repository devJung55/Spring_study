package com.example.ex00.dependency;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class School {
    private List<Teacher> teachers;
    private List<Student> students;
}
