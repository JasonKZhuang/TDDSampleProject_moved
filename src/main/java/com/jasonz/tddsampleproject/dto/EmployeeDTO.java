package com.jasonz.tddsampleproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String comments;
}
