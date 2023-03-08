package com.example.Assignment.Controllers;


import com.example.Assignment.DTOs.EmployeeDto;
import com.example.Assignment.Models.Employee;
import com.example.Assignment.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody EmployeeDto employeeDto){

        try {
            employeeService.add(employeeDto);

        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Employee added successfully", HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-employee")
    public ResponseEntity get(@RequestParam("age") int age, @RequestParam("ratings")  double ratings){

        List<Employee> list = new ArrayList<>();
        try {
            list = employeeService.getEmployee(age, ratings);
        }catch (Exception e){

            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-count-of-employee")
    public ResponseEntity getCount(@RequestParam("ratings") double ratings){

        int count = 0;
        try {
            count = employeeService.getEmployeeCount(ratings);
        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(count, HttpStatus.ACCEPTED);
    }
}
