package com.example.Assignment.DTOs;

import com.example.Assignment.Models.Employee;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BossDto {

    private String name;

    private int age;

    private double ratings;

    private int salary;

}
