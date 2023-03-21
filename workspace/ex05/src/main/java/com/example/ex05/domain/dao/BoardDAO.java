package com.example.ex05.domain.dao;

import com.example.ex05.domain.vo.BoardVO;
import com.example.ex05.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

//    게시글 추가
    public void save(BoardVO boardVO){
        boardMapper.insert(boardVO);
    }

//    게시글 조회
    public BoardVO findById(Long boardId){
        return boardMapper.select(boardId);
    }

//    게시글 수정
    public void setBoardVO(BoardVO boardVO){
        boardMapper.update(boardVO);
    }

//    게시글 삭제
    public void delete(Long boardId){
        boardMapper.delete(boardId);
    }

//    게시글 전체 조회
    public List<BoardVO> findAll(){
        return boardMapper.selectAll();
    }
}














