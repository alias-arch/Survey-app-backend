package com.example.Surveyappbackend.repository;

import com.example.Surveyappbackend.model.Repondant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepondantRepository extends JpaRepository<Repondant,Long> {
}
