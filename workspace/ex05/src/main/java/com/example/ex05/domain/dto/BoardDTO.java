package com.example.ex05.domain.dto;

import com.example.ex05.domain.vo.BoardVO;
import com.example.ex05.domain.vo.FileVO;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardDTO {
    private Long boardId;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;
    private List<FileVO> files;

    public BoardDTO toDTO(BoardVO boardVO) {
        this.boardId = boardVO.getBoardId();
        this.boardTitle = boardVO.getBoardTitle();
        this.boardWriter = boardVO.getBoardWriter();
        this.boardContent = boardVO.getBoardContent();
        this.boardRegisterDate = boardVO.getBoardRegisterDate();
        this.boardUpdateDate = boardVO.getBoardUpdateDate();
        return this;
    }
}


















