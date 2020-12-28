package com.zzyy.dev.allin;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AllInApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void testSub() {

        String originalFilename = "123.jpg";
        String type = StringUtils.substringAfterLast(originalFilename, ".");
        System.out.println(type);
    }
}
