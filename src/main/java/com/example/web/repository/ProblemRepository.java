package com.example.web.repository;

import com.example.web.entity.Problems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problems, Long> {
}
