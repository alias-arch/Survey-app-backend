package com.example.Surveyappbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Surveyappbackend.model.Repondant;
import com.example.Surveyappbackend.repository.RepondantRepository;

/**
 * RepondantController
 */
@RestController()
@RequestMapping(path = "/api/responses")
public class RepondantController {
  @Autowired
  private RepondantRepository repondantRepository;

  @PostMapping("/repondant")
  public ResponseEntity<Repondant> addRepondant(@RequestBody Repondant repondant) {
    return ResponseEntity.ok(repondantRepository.save(repondant));

  }
}
