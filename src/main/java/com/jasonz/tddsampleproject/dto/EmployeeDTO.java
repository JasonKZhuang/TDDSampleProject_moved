package com.jasonz.tddsampleproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private int empId;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String comments;
}
