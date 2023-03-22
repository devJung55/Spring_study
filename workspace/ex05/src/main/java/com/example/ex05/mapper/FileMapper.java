package com.example.ex05.mapper;

import com.example.ex05.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {
//    파일 추가
    public void insert(FileVO fileVO);

//    파일 전체 조회
    public List<FileVO> selectAll(Long boardId);

//    파일 삭제
    public void delete(Long boardId);

//    전일 등록된 파일 조회
    public List<FileVO> selectYesterday();
}
