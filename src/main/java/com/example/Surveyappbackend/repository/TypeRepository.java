package com.example.Surveyappbackend.repository;

import com.example.Surveyappbackend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
}
