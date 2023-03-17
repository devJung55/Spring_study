package com.example.ex03.service;

import com.example.ex03.domain.dao.UserDAO;
import com.example.ex03.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

//    회원 조회
    public UserVO getUser(Long userId) {
        return userDAO.findById(userId);
    }

//    목록
    public List<UserVO> getList() {
        return userDAO.findAll();
    }
}
