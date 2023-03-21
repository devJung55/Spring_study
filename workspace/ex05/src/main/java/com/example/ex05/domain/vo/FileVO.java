package com.example.ex05.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FileVO {
    private Long fileId;
    private String fileOriginalName;
    private String fileUuid;
    private String filePath;
    private String fileSize;
    private boolean fileType;
    private Long boardId;
}
