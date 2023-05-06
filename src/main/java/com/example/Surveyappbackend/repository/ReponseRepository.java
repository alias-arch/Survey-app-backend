package com.example.Surveyappbackend.repository;

import com.example.Surveyappbackend.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse,Long> {
}
