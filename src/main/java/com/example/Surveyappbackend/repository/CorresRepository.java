package com.example.Surveyappbackend.repository;

import com.example.Surveyappbackend.model.Correspondance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorresRepository extends JpaRepository<Correspondance,Long> {
}
