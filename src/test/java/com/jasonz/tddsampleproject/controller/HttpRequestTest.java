package com.jasonz.tddsampleproject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    // the use of webEnvironment=RANDOM_PORT to start the server with a random port
    // (useful to avoid conflicts in test environments),
    // and the injection of the port with @LocalServerPort.
    @LocalServerPort
    private int port;

    //spring Boot has automatically provided a TestRestTemplate for you. All you have to do is add @Autowired to it.
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(
                this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)
        ).contains("Hello, World");
    }
}