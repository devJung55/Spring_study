package com.example.ex05.mapper;

import com.example.ex05.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    BoardMapper boardMapper;

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목1");
        boardVO.setBoardWriter("테스트1");
        boardVO.setBoardContent("테스트 내용1");

        boardMapper.insert(boardVO);

        assertThat(boardVO.getBoardId()).isEqualTo(1L);
    }

    @Test
    public void selectTest(){
        assertThat(boardMapper.select(4L).getBoardTitle()).isEqualTo("수정된 제목");
    }

    @Test
    public void updateTest(){
        BoardVO boardVO = boardMapper.select(4L);
        boardVO.setBoardTitle("수정된 제목");

        boardMapper.update(boardVO);
    }

    @Test
    public void deleteTest(){
        boardMapper.delete(3L);
    }

    @Test
    public void selectAllTest(){
        assertThat(boardMapper.selectAll().size()).isEqualTo(1);
    }
}

























