package com.example.ex05.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardVO {
    private Long boardId;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;
}
