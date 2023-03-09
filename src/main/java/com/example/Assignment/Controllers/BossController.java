package com.example.Assignment.Controllers;

import com.example.Assignment.DTOs.BossDto;
import com.example.Assignment.Services.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boss")
public class BossController {

    @Autowired
    BossService bossService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody BossDto bossDto){

        try {
            bossService.add(bossDto);

        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Boss added successfully", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestParam("ratings") double ratings, @RequestParam("salary") int salary){

        try {
            bossService.updateSalary(ratings, salary);
        }catch (Exception e){

            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Salary updated successfully", HttpStatus.ACCEPTED);
    }


}


// Create a employee-boss management system where you can perform important CRUD operations upon them.
// POST :ADD employee,addboss
// Get employees who are under a given age and have rating greater than x.
// PUT : update all the boss salary of the boses, by x whose rating is > y.
// GET:Find out all count of the employees, who’s bossRating and employee rating > x.