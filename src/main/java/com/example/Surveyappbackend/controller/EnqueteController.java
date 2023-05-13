package com.example.Surveyappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Surveyappbackend.model.Enquete;
import com.example.Surveyappbackend.service.EnqueteService;

@RestController
@RequestMapping(path = "/api/Enquete")
public class EnqueteController {

  @Autowired
  private EnqueteService enquteservice;

  @GetMapping
  public List<Enquete> getEnquetes() {
    return this.enquteservice.getEnquetes();
  }

  @PostMapping
  public void saveEnquete(@RequestBody Enquete enquete) {
    this.enquteservice.saveEnquete(enquete);

  }

  @PutMapping
  public void updateEnquete(@RequestBody Enquete enquete) {
    this.enquteservice.updateEnquete(enquete);

  }

  @DeleteMapping("/{Id}")
  public void deleteEnquete(Long Id) {
    this.enquteservice.deleteEnquete(Id);

  }

}
