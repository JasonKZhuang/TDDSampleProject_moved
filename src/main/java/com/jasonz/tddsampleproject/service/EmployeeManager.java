package com.jasonz.tddsampleproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasonz.tddsampleproject.dao.EmployeeDao;
import com.jasonz.tddsampleproject.dto.EmployeeDTO;
import com.jasonz.tddsampleproject.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeManager {
    private final EmployeeDao employeeDao;

    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<EmployeeDTO> getEmployeeList() {
        log.info("This is Employee Manager Service");
        List<EmployeeDTO> retList = new ArrayList<>();
        ObjectMapper om = new ObjectMapper();
        List<Employee> employees = employeeDao.getEmployeeList();
        int i = 1;
        for (Employee e : employees) {
            EmployeeDTO dto = new EmployeeDTO();
            BeanUtils.copyProperties(e, dto);
            dto.setComments("" + i);
            retList.add(dto);
            i++;
        }
        return retList;
    }

    public EmployeeDTO getEmployeeById(int id) {
        EmployeeDTO dto = new EmployeeDTO();
        Employee e = employeeDao.getEmployeeById(id);
        BeanUtils.copyProperties(e, dto);
        return dto;
    }

    public void addEmployee(EmployeeDTO dto) {
        Employee empEntity = new Employee();
        BeanUtils.copyProperties(dto, empEntity);
        employeeDao.createEmployee(empEntity);
    }
}
