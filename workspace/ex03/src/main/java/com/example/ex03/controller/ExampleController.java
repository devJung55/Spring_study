package com.example.ex03.controller;

import com.example.ex03.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ExampleController {

    @GetMapping(value = "/ex01", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> ex01() throws UnsupportedEncodingException {
        return new ResponseEntity<>(new String("ex01".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    @GetMapping("/ex02")
    public String ex02(){
        return "ex02";
    }

    @GetMapping("/ex03")
    public String ex03(String name){
        return name + "님";
    }

    @PostMapping("/ex04")
    public String ex04(String name, Integer age) {
        return name + "(" + age + ")";
    }

    @PostMapping("/ex05")
    public UserVO ex05(){
        UserVO userVO = new UserVO();
        userVO.setUserId(1L);
        userVO.setUserName("한동석");
        userVO.setUserAge(20);
        return userVO;
    }

    @PostMapping("/ex06")
    public String ex06(@RequestBody UserVO userVO){
        log.info(userVO.toString());
        return "success";
    }

    @PostMapping("/ex07")
    public List<UserVO> ex07(){
        List<UserVO> users = new ArrayList<>();
        UserVO userVO1 = new UserVO();
        UserVO userVO2 = new UserVO();

        userVO1.setUserId(1L);
        userVO1.setUserName("한동석");
        userVO1.setUserAge(20);

        userVO2.setUserId(1L);
        userVO2.setUserName("한동석");
        userVO2.setUserAge(20);

        users.add(userVO1);
        users.add(userVO2);
        return users;
    }

    @PutMapping("/update/users/{userId}")
    public String updateAll(@PathVariable("userId") Long userId){
        return "전체 수정: " + userId;
    }

    @PatchMapping("/update/users/{userId}")
    public String update(@PathVariable("userId") Long userId){
        return "부분 수정: " + userId;
    }

    @DeleteMapping("/delete/users/{userId}")
    public Long delete(@PathVariable("userId") Long userId){
        return userId;
    }
}












