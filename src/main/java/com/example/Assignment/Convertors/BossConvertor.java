package com.example.Assignment.Convertors;

import com.example.Assignment.DTOs.BossDto;
import com.example.Assignment.Models.Boss;

public class BossConvertor {

    public static Boss convertDtoToEntity(BossDto bossDto){

        Boss boss = Boss.builder().
                age(bossDto.getAge()).
                name(bossDto.getName()).
                ratings(bossDto.getRatings()).
                salary(bossDto.getSalary()).
                build();

        return boss;
    }
}
