package com.jasonz.tddsampleproject.controller;

import com.jasonz.tddsampleproject.controller.GreetingController;
import com.jasonz.tddsampleproject.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * We can narrow the tests to only the web layer by using @WebMvcTest
 * In this test, Spring Boot instantiates only the web layer rather than the whole context.
 * In an application with multiple controllers, you can even ask for only one to be instantiated by using HomeController.class
 */
@WebMvcTest(GreetingController.class)
public class WebMockTest {
    @Autowired
    private MockMvc mockMvc;

    // We use @MockBean to create and inject a mock for the GreetingService
    // (if you do not do so, the application context cannot start),
    // and we set its expectations using Mockito.
    @MockBean
    private GreetingService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }
}