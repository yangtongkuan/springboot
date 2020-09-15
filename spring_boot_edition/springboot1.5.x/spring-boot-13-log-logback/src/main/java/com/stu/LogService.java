package com.stu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    final static Logger log = LoggerFactory.getLogger(LogService.class);

    public void log() {
        log.trace("这个 trance 日志 ---->");
        log.debug("这个 debug 日志 ---->");
        log.info("这个 info 日志 ---->");
        log.warn("这个 warn 日志 ---->");
        log.error("这个 error 日志 ---->");
    }
}
