package com.stu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringBoot13LogLogbackApplication.class)
@RunWith(SpringRunner.class)
public class SpringBoot13LogLogbackApplicationTests {

    @Autowired
    private LogService logService;

    @Test
    public void contextLoads() {
        logService.log();
    }

}
