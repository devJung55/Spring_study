package com.example.ex05.task;

import com.example.ex05.domain.vo.FileVO;
import com.example.ex05.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileCheckTask {
    private final FileService fileService;

    /*
     *   0 * * * * * : 매 분 0초마다
     *   0/1 * * * * : 매 1초 간격
     *   0 0/1 * * * : 매 1분 간격
     *   0 0/5 * ? : 매 5분 간격
     *   0 0 0/1 * * : 매 1시간 간격
     *   0 0 0 * * ? : 매일 0시 마다
     *   0 0 0 1 * ? : 매월 1일 마다
     *   * 10-13 * * * * : 매 10, 11, 12, 13분에 동작한다.
     * */
    @Scheduled(cron = "0 * * * * *")
    public void checkFiles() {
        List<FileVO> fileVOS = fileService.getListFromYesterday();

        List<Path> fileVO_Paths = fileVOS.stream()
                .map(fileVO -> Paths.get("C:/upload/" + getPathFromYesterday(), fileVO.getFileUuid() + "_" + fileVO.getFileOriginalName()))
                .collect(Collectors.toList());

        log.info("======================================================");
        fileVO_Paths.stream().map(Path::toString).forEach(log::info);
        log.info("======================================================");

        fileVOS.stream().filter(FileVO::isFileType)
                .map(fileVO -> Paths.get("C:/upload/" + getPathFromYesterday(), "t_" + fileVO.getFileUuid() + "_" + fileVO.getFileOriginalName()))
                .forEach(fileVO_Paths::add);

        log.info("======================================================");
        fileVO_Paths.stream().map(Path::toString).forEach(log::info);
        log.info("======================================================");
        log.info(getPathFromYesterday());
        File directory = Paths.get("C:/upload", getPathFromYesterday()).toFile();
        log.info(directory.getAbsolutePath());
        log.info("======================================================");
        Arrays.stream(directory.listFiles(file -> !fileVO_Paths.contains(file.toPath()))).map(File::getAbsolutePath).forEach(log::info);
        log.info("======================================================");

        Arrays.stream(directory.listFiles(file -> !fileVO_Paths.contains(file.toPath()))).forEach(File::delete);
    }

    private String getPathFromYesterday(){
        LocalDate yesterday = LocalDate.now();
        yesterday = yesterday.minusDays(1);

        return DateTimeFormatter.ofPattern("yyyy/MM/dd").format(yesterday);
    }
}






















