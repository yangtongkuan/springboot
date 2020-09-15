package com.stu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SpringBoot13LogBackApplicationTests {

    protected static final Logger log = LoggerFactory.getLogger(SpringBoot13LogBackApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void logBack() {
        log.trace("这是------>trance");
        log.debug("这是------>debug");
        log.info("这是------>info");
        log.warn("这是------>warn");
        log.error("这是------>error");
    }
}
