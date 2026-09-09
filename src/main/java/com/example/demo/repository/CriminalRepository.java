package com.example.demo.repository;

import com.example.demo.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {
}