package com.ccb.logback.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final static Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/testLog")
    public String testLog() {
        logger.warn("testlogwarn");
        logger.info("testloginfo");
        return "testLog";
    }

}
