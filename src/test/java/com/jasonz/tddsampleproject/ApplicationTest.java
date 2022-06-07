package com.jasonz.tddsampleproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
/**
 * reference:
 * https://www.youtube.com/watch?v=s9vt6UJiHg4
 * https://www.youtube.com/watch?v=z6gOPonp2t0
 * https://www.youtube.com/watch?v=Geq60OVyBPg
 * https://www.youtube.com/watch?v=MRG6rm54lhA
 * https://www.youtube.com/watch?v=Hh17JDpsKqc
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {

    @Test
    public void loadContext(){
        System.out.println("lanch a spring boot application");
    }

}