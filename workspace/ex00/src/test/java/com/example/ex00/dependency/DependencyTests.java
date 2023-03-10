package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DependencyTests {
    @Autowired // 단위 테스트에서는 필드 주입만 사용 가능하다.
    Coding coding;

    @Autowired
    Teacher teacher;

    @Autowired
    Student student;

    @Autowired
    School school;

    @Autowired
    Class studentClass;

    @Test
    public void testTeacher(){
        log.info(String.valueOf(teacher));
    }

    @Test
    public void testClass(){
        log.info(String.valueOf(studentClass));
    }

    @Test
    public void testStudent(){
        log.info(String.valueOf(student));
    }

    @Test
    public void testSchool(){
        log.info(String.valueOf(school));
    }

    @Test
    public void testCoding(){
        log.info(String.valueOf(coding));
    }

}
