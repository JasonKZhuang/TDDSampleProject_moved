package com.jasonz.tddsampleproject.service;

import com.jasonz.tddsampleproject.dao.EmployeeDao;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * this way:
 * to process Mockito annotations with JUnit 5,
 * we need to use MockitoExtention that automatically initializes all the objects annotated with @Mock and @InjectMocks annotations.
 */
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTestWayA {

    @InjectMocks
    EmployeeService manager;

    @Mock
    EmployeeDao dao;
}