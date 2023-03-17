package com.example.ex03.controller;

import com.example.ex03.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

//    회원 조회
    @GetMapping("/detail/users/{userId}")
    public void getUser(@PathVariable("userId") Long userId) {
        log.info(userService.getUser(userId).toString());
    }

//    회원 목록
    @GetMapping("/list/users")
    public void getList() {
        log.info(userService.getList().toString());
    }
}
