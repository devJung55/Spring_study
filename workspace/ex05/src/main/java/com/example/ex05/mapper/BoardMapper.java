package com.example.ex05.mapper;

import com.example.ex05.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    게시글 추가
    public void insert(BoardVO boardVO);

//    게시글 조회
    public BoardVO select(Long boardId);

//    게시글 수정
    public void update(BoardVO boardVO);

//    게시글 삭제
    public void delete(Long boardId);

//    게시글 전체 조회
    public List<BoardVO> selectAll();
}
