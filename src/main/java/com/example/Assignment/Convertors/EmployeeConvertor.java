package com.example.Assignment.Convertors;

import com.example.Assignment.DTOs.EmployeeDto;
import com.example.Assignment.Models.Employee;

public class EmployeeConvertor {

    public static Employee convertDtoToEntity(EmployeeDto employeeDto){

        Employee employee = Employee.builder().
                name(employeeDto.getName()).
                age(employeeDto.getAge()).
                ratings(employeeDto.getRatings()).
                salary(employeeDto.getSalary()).
                build();

        return employee;
    }
}
