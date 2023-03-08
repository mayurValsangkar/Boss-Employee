package com.example.Assignment.Repositories;

import com.example.Assignment.Models.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends JpaRepository<Boss, Integer> {
}
