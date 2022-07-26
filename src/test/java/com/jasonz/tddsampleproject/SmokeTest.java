package com.jasonz.tddsampleproject;

import com.jasonz.tddsampleproject.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    // Spring interprets the @Autowired annotation, and the controller is injected before the test methods are run.
    @Autowired
    private HomeController controller;

    @Test
    public void contextLoads() throws Exception {
        // We use AssertJ (which provides assertThat() and other methods) to express the test assertions.
        assertThat(controller).isNotNull();
    }
}