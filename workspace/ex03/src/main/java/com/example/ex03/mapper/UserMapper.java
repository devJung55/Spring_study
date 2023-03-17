package com.example.ex03.mapper;

import com.example.ex03.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
//    회원 조회
    public UserVO select(Long userId);

//    목록
    public List<UserVO> selectAll();
}
