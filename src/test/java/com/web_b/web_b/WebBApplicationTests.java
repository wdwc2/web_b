package com.web_b.web_b;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class WebBApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDateTime.now());
    }

}
