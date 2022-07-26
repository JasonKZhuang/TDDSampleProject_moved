package com.jasonz.tddsampleproject.dao;

import com.jasonz.tddsampleproject.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class EmployeeDao {
    private final Map<Integer, Employee> DB = new HashMap<>();

    public List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>();
        list.addAll(DB.values());
        return list;
    }

    public Employee getEmployeeById(int id) {
        Employee e = DB.get(id);
        if (e == null) {
            e = new Employee();
        }
        return e;
    }

    public void createEmployee(Employee employee) {
        log.info("This is employee dao adding new employee.");
        employee.setEmpId(DB.keySet().size() + 1);
        DB.put(employee.getEmpId(), employee);
    }

    public void updateEmployee(Employee employee) {
        DB.put(employee.getEmpId(), employee);
    }

    public void deleteEmployee(int id) {
        DB.remove(id);
    }
}
