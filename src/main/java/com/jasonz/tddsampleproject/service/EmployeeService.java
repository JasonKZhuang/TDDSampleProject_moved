package com.jasonz.tddsampleproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasonz.tddsampleproject.dao.EmployeeDao;
import com.jasonz.tddsampleproject.dao.EmployeeRepository;
import com.jasonz.tddsampleproject.dto.EmployeeDTO;
import com.jasonz.tddsampleproject.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeRepository employeeRepository;

    public void newEmployeeToDb(EmployeeDTO argDto) {
        Employee empEntity = new Employee();
        BeanUtils.copyProperties(argDto, empEntity);
        employeeRepository.save(empEntity);
    }

    public void updateEmployeeToDb(Integer argId, EmployeeDTO argDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(argId);
        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException(String.format("The employee with id [%d] cannot be found.", argId));
        }
        Employee employee = optionalEmployee.get();
        employee.setEmail(argDto.getEmail());
        employee.setFirstName(argDto.getFirstName());
        employee.setLastName(argDto.getLastName());
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer argId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(argId);
        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException(String.format("The employee with id [%d] cannot be found.", argId));
        }
        employeeRepository.delete(optionalEmployee.get());
    }

    public EmployeeDTO findEmployeeById(Integer argId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(argId);
        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException(String.format("The employee with id [%d] cannot be found.", argId));
        }
        EmployeeDTO retDTO = new EmployeeDTO();
        BeanUtils.copyProperties(optionalEmployee.get(), retDTO);
        return retDTO;
    }

    public EmployeeDTO findEmployeeByFullName(String firstName, String lastName) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
        if (employee == null) {
            throw new RuntimeException(String.format("The employee with name [%s %s] cannot be found.", firstName, lastName));
        }
        EmployeeDTO retDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, retDTO);
        return retDTO;
    }

    public List<EmployeeDTO> findEmployees() {
        List<EmployeeDTO> retValue = new ArrayList<>();
        EmployeeDTO dto;
        Employee tempEmployee;
        Iterable<Employee> employees = employeeRepository.findAll();
        while (employees.iterator().hasNext()) {
            tempEmployee = employees.iterator().next();
            dto = new EmployeeDTO();
            dto.setEmpId(tempEmployee.getEmpId());
            dto.setFirstName(tempEmployee.getFirstName());
            dto.setLastName(tempEmployee.getLastName());
            dto.setEmail(tempEmployee.getEmail());
            retValue.add(dto);
        }
        return retValue;
    }

    public void newEmployeeToMemory(EmployeeDTO argDto) {
        Employee empEntity = new Employee();
        BeanUtils.copyProperties(argDto, empEntity);
        employeeDao.createEmployee(empEntity);
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


}
