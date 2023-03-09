package com.example.Assignment.Services;

import com.example.Assignment.Convertors.EmployeeConvertor;
import com.example.Assignment.DTOs.EmployeeDto;
import com.example.Assignment.Models.Boss;
import com.example.Assignment.Models.Employee;
import com.example.Assignment.Repositories.BossRepository;
import com.example.Assignment.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BossRepository bossRepository;

    public void add(EmployeeDto employeeDto){

        // We have converted Dto to Entity
        Employee employee = EmployeeConvertor.convertDtoToEntity(employeeDto);

        int bossId = employeeDto.getBoosId();

        Boss boss = bossRepository.findById(bossId).get();
        employee.setBoss(boss);
        //employeeRepository.save(employee);

        bossRepository.save(boss);
    }

    // Get employees who are under a given age and have rating greater than x.
    public List<Employee> getEmployee(int age, double ratings){

        List<Employee> employeeList = employeeRepository.findAll();

        List<Employee> requireEmplyeeList = new ArrayList<>();

        for(Employee employee : employeeList){

            if(employee.getAge()==age && employee.getRatings() > ratings){
                requireEmplyeeList.add(employee);
            }
        }

        return requireEmplyeeList;
    }

    // GET:Find out all count of the employees, who’s bossRating and employee rating > x.
    public int getEmployeeCount(double ratings){

        List<Employee> employeeList = employeeRepository.findAll();

        int count = 0;
        for(Employee employee : employeeList){

            if(employee.getRatings() > ratings && employee.getBoss().getRatings() > ratings){
                count += 1;
            }
        }

        return count;
    }
}
