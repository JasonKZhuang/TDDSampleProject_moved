package com.jasonz.tddsampleproject;

import com.jasonz.tddsampleproject.configure.EmployeeServiceTestContextConfiguration;
import com.jasonz.tddsampleproject.dao.EmployeeRepository;
import com.jasonz.tddsampleproject.entity.Employee;
import com.jasonz.tddsampleproject.service.EmployeeService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
//The @SpringBootTest annotation is useful when we need to bootstrap the entire container.
//We're using WebEnvironment.MOCK here so that the container will operate in a mock servlet environment.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@Import(EmployeeServiceTestContextConfiguration.class)
public class RestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository repository;

    // However, to test the Service layer,
    // we don't need to know or care about how the persistence layer is implemented.
    // Ideally, we should be able to write and test our Service layer code without wiring in our full persistence layer.
    @Autowired
    private EmployeeService employeeService;


    @Before
    public void setUp() {
//        Employee emp = new Employee("Jason","Zhuang");
//        Mockito.when(repository.findByFirstNameAndLastName(emp.getFirstName(),emp.getLastName()))
//               .thenReturn(emp);
    }

    // write test cases here


}