package com.example.ex05.service;

import com.example.ex05.domain.dao.FileDAO;
import com.example.ex05.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {
    private final FileDAO fileDAO;

//    파일 추가
    public void write(List<FileVO> files){
        files.forEach(file -> fileDAO.save(file));
    }

//    파일 전체 조회
    public List<FileVO> getList(Long boardId){
        return fileDAO.findByBoardId(boardId);
    }

//    파일 삭제
    public void remove(Long boardId){
        fileDAO.delete(boardId);
    }

//    전일 등록된 파일 조회
    public List<FileVO> getListFromYesterday(){
        return fileDAO.findByFilePath();
    }
}

























