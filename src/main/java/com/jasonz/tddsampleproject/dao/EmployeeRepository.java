/**
 * Project: TDDSampleProject
 * Date: 8/12/2022
 * Author: Jason
 */
package com.jasonz.tddsampleproject.dao;

import com.jasonz.tddsampleproject.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByEmail(String email);
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
