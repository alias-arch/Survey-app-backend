package com.example.Surveyappbackend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepondantRepository extends JpaRepository<Repondant,Long> {
}