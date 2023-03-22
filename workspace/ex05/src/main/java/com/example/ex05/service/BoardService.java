package com.example.ex05.service;

import com.example.ex05.domain.dao.BoardDAO;
import com.example.ex05.domain.dao.FileDAO;
import com.example.ex05.domain.dto.BoardDTO;
import com.example.ex05.domain.vo.BoardVO;
import com.example.ex05.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDAO boardDAO;
    private final FileDAO fileDAO;

//    게시글 추가
    public void write(BoardVO boardVO){
        boardDAO.save(boardVO);
    }

//    게시글 조회
    public BoardDTO getBoard(Long boardId){
        BoardDTO boardDTO = new BoardDTO().toDTO(boardDAO.findById(boardId));
        boardDTO.setFiles(fileDAO.findByBoardId(boardId));
        return boardDTO;
    }

//    게시글 수정
    public void modify(BoardVO boardVO){
        boardDAO.setBoardVO(boardVO);
    }

//    게시글 삭제
    public void remove(Long boardId){
        boardDAO.delete(boardId);
    }

//    게시글 전체 조회
    public List<BoardVO> getList(){
        return boardDAO.findAll();
    }
}
