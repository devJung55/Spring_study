package com.example.ex05.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileCheckTask {
    @Scheduled(cron = "0 0 2 * * *")
    public void checkFiles() {

    }
}
