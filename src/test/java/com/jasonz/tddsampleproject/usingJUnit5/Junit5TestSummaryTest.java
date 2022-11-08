package com.jasonz.tddsampleproject.usingJUnit5;

import com.jasonz.tddsampleproject.dto.EmployeeDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Reference: JUnit 5 tutorial - Learn how to write unit tests
 * (https://www.vogella.com/tutorials/JUnit/article.html)
 *
 * JUnit 5 comes with multiple assert statements, which allows you to test your code under test.
 * Simple assert statements like the following allow to check for true, false or equality.
 * All of them are static methods from the org.junit.jupiter.api.Assertions.* package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Junit5TestSummaryTest {

    Junit5TestSummary testSummary;

    @BeforeEach
    void setUp() {
        testSummary = new Junit5TestSummary();
    }

    @Order(1)
    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        int factValue = testSummary.multiply(4, 5);
        assertEquals(20, factValue, "Regular multiplication should work");
    }

    @Order(2)
    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        assertEquals(0, testSummary.multiply(0, 5), "Multiple with zero should be zero");
        assertEquals(0, testSummary.multiply(5, 0), "Multiple with zero should be zero");
    }

    // Messages can be created via lambda expressions, to avoid the overhead in case the construction of the message is expensive.
    @Test
    void testDemoForLambdaExpressionMessage() {
        assertTrue('a' > 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    // Testing that certain exceptions are thrown can be done with the org.junit.jupiter.api.Assertions.expectThrows() assert statement.
    // You define the expected Exception class and provide code that should throw the exception.
    @Test
    void testDemoForException() {
        // set up user
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {});
        assertEquals("Age must be an Integer.", exception.getMessage());
    }

    @Test
    void groupedAssertions() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("Jason");
        employeeDTO.setLastName("User");
        assertAll("employee name",
                () -> assertEquals("John", employeeDTO.getFirstName()),
                () -> assertEquals("User", employeeDTO.getLastName())
        );
    }

    // If you want to ensure that a test fails,
    // if it isn’t done in a certain amount of time you can use the assertTimeout() method.
    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(1), () -> {
            System.out.println("execute some methods");
        });
    }

    // if you have to check a return value
    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofSeconds(1), () -> {
            return "restService.request(request)";
        });
        assertEquals(200, "");
    }

    /**
     * Using Dynamic Tests (https://www.vogella.com/tutorials/JUnit/article.html#dynamic_tests)
     * Dynamic test methods are annotated with @TestFactory,
     * and allow you to create multiple tests of type DynamicTest with your code.
     * They can return:
     * an Iterable
     * a Collection
     * a Stream
     * JUnit 5 creates and runs all dynamic tests during test execution.
     *
     * @return
     */
    @TestFactory
    Stream<DynamicTest> testDifferentMultiplyOperations() {
        MyClass tester = new MyClass();
        int[][] data = new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
                assertEquals(expected, tester.multiply(m1, m2));
            });
        });
    }

    /**
     * Using the @TempDir annotation to create temporary files and paths
     * The @TempDir annotations allows to annotate non-private fields or method parameters in a test method of type Path or File.
     * JUnit 5 has registered a ParameterResolutionException for this annotation,
     * and will create temporary files and paths for the tests.
     * It will also remove the temporary files are each test.
     * @param tempDir
     * @param tempDir2
     * @throws IOException
     */
    @Test
    @DisplayName("Ensure that two temporary directories with same files names and content have same hash")
    void hashTwoDynamicDirectoryWhichHaveSameContent(@TempDir Path tempDir, @TempDir Path tempDir2) throws IOException {

        Path file1 = tempDir.resolve("myfile.txt");

        List<String> input = Arrays.asList("input1", "input2", "input3");
        Files.write(file1, input);

        assertTrue(Files.exists(file1), "File should exist");

        Path file2 = tempDir2.resolve("myfile.txt");

        Files.write(file2, input);
        assertTrue(Files.exists(file2), "File should exist");

    }


    // class to be tested
    class MyClass {
        public int multiply(int i, int j) {
            return i * j;
        }
    }

}