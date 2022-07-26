package com.jasonz.tddsampleproject.service;

import com.jasonz.tddsampleproject.dao.EmployeeDao;
import com.jasonz.tddsampleproject.dto.EmployeeDTO;
import com.jasonz.tddsampleproject.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EmployeeManagerTestWayB {

    @InjectMocks
    EmployeeManager manager;

    @Mock
    EmployeeDao dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllEmployeesTest() {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "John", "John", "howtodoinjava@gmail.com");
        Employee empTwo = new Employee(2, "Alex", "kolenchiski", "alexk@yahoo.com");
        Employee empThree = new Employee(3, "Steve", "Waugh", "swaugh@gmail.com");
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
        when(dao.getEmployeeList()).thenReturn(list);

        //test
        List<EmployeeDTO> empList = manager.getEmployeeList();

        assertEquals(3, empList.size());
        assertTrue(empList.get(0).getComments().equals("1"));

        verify(dao, times(1)).getEmployeeList();
    }

    @Test
    public void getEmployeeByIdTest() {
        when(dao.getEmployeeById(1)).thenReturn(new Employee(1, "Lokesh", "Gupta", "user@email.com"));

        EmployeeDTO emp = manager.getEmployeeById(1);

        assertEquals("Lokesh", emp.getFirstName());
        assertEquals("Gupta", emp.getLastName());
        assertEquals("user@email.com", emp.getEmail());
    }

    @Test
    public void createEmployeeTest() {
        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(1);
        emp.setFirstName("Lokesh");
        emp.setLastName("Gupta");
        emp.setEmail("user@email.com");

        manager.addEmployee(emp);
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp, employee);
        verify(dao, times(1)).createEmployee(employee);
    }
}