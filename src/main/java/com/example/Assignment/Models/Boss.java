package com.example.Assignment.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boss")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private double ratings;

    private int salary;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

}
