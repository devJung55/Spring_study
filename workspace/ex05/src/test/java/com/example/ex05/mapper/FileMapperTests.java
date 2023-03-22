package com.example.ex05.mapper;

import com.example.ex05.domain.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class FileMapperTests {
    @Autowired
    FileMapper fileMapper;

    @Test
    public void insertTest(){
        FileVO fileVO = new FileVO();
        fileVO.setFileOriginalName("테스트1.png");
        fileVO.setFileUuid(UUID.randomUUID().toString());
        fileVO.setFilePath("2023/03/21");
        fileVO.setFileSize("1024");
        fileVO.setBoardId(5L);

        fileMapper.insert(fileVO);
    }

    @Test
    public void selectAllTest(){
        assertThat(fileMapper.selectAll(5L).get(0).getFileOriginalName()).isEqualTo("테스트1.png");
    }

    @Test
    public void deleteTest(){
        fileMapper.delete(5L);
        assertThat(fileMapper.selectAll(5L).size()).isEqualTo(0);
    }

    @Test
    public void selectYesterdayTest(){
        fileMapper.selectYesterday().stream().map(FileVO::getFileOriginalName).forEach(log::info);
    }
}



















