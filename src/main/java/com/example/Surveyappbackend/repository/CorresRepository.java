package com.example.Surveyappbackend.repository;

import com.example.Surveyappbackend.model.Correspondance;
import com.example.Surveyappbackend.model.Enquete;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorresRepository extends JpaRepository<Correspondance, Long> {
  public List<Correspondance> findByEnquete(Enquete enquete);
}
