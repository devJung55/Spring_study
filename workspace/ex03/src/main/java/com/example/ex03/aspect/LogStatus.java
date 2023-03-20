package com.example.ex03.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Configuration
@Slf4j
public class LogStatus {
    @Before("@annotation(com.example.ex03.aspect.annotation.LogStatus)")
    public void beforeStart(JoinPoint joinPoint) {
        log.info(Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(",")));
    }
}
