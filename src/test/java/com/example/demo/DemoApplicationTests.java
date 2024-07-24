package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@Import(ContainersConfiguration.class)
class DemoApplicationTests {
    @Test
    void contextLoads() {
    }
}
