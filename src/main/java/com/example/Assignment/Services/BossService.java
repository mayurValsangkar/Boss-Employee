package com.example.Assignment.Services;

import com.example.Assignment.Convertors.BossConvertor;
import com.example.Assignment.DTOs.BossDto;
import com.example.Assignment.Models.Boss;
import com.example.Assignment.Repositories.BossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BossService {

    @Autowired
    BossRepository bossRepository;

    public void add(BossDto bossDto){

        // We have converted Dto to Entity
        Boss boss = BossConvertor.convertDtoToEntity(bossDto);

        bossRepository.save(boss);
    }

    // PUT : update all the boss salary of the boses, by x whose rating is > y.
    public void updateSalary(double ratings, int salary){

        List<Boss> bossList = bossRepository.findAll();

        for(Boss boss : bossList) {

            if (boss.getRatings() > ratings) {
                int previousSalary = boss.getSalary();
                boss.setSalary(previousSalary + salary);

                bossRepository.save(boss);
            }
        }
    }
}
