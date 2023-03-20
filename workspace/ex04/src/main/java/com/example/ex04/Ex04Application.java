package com.example.ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Ex04Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex04Application.class, args);
    }

}
