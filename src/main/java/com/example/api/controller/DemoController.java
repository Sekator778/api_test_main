package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
@Slf4j
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        log.info("Hello, World!");
        return ResponseEntity.ok("Hello, World!");
    }

    /**
     * send every minute message t
     */
    @Scheduled(cron = "0 0/1 * * * *")
    public void sendLogs() {
        log.info("Hello, from cron !" + System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 100)
    public void scheduleFixedDelayTask() {
        log.info(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
}
