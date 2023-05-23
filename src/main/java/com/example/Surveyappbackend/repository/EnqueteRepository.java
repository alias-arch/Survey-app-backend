package com.example.Surveyappbackend.repository;

import com.example.Surveyappbackend.model.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnqueteRepository extends JpaRepository<Enquete, Long> {

}
