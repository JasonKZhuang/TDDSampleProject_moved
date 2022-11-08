package com.jasonz.tddsampleproject.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DemoClassTest {

    private DemoClass demoClass;

    //The method annotated with @BeforeEach runs before each test
    @BeforeEach
    void setUp() {
        demoClass = new DemoClass();
    }

    @Test //A method annotated with @Test defines a test method
    @DisplayName("Simple multiplication should work.") //@DisplayName can be used to define the name of the test which is displayed to the user
    void testMultiply() {
        assertEquals(20, demoClass.multiply(4, 5), "Regular multiplication should work");
    }

    @RepeatedTest(5) //	@RepeatedTest defines that this test method will be executed multiple times, in this example 5 times
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        // This is an assert statement which validates that expected and actual value is the same, if not the message at the end of the method is shown
        assertEquals(0, demoClass.multiply(0, 5), "Multiple with zero should be zero");
        assertEquals(0, demoClass.multiply(5, 0), "Multiple with zero should be zero");
    }

    @Test
    @DisplayName("something is here.")
    void testDemoMethod() {
        Date newDate = new Date();
        String result = demoClass.convertDateToString(newDate);
        assertEquals("2022-11-03", result.substring(0,10));
    }
}