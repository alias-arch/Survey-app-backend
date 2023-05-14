package com.example.Surveyappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  private EnqueteService enqueteservice;

  @GetMapping
  public List<Enquete> getEnquetes() {
    return this.enqueteservice.getEnquetes();
  }

  @GetMapping("/{EnqueteId}")
  public Enquete getEnquete(@PathVariable Long EnqueteId) {
    return this.enqueteservice.getEnquete(EnqueteId);
  }

  @PostMapping
  public void saveEnquete(@RequestBody Enquete enquete) {
    this.enqueteservice.saveEnquete(enquete);

  }

  @PutMapping("/{EnqueteId}")
  public ResponseEntity<Enquete> updateEnquete(@PathVariable Long EnqueteId, @RequestBody Enquete enquete) {
    Enquete updatedEnquete = this.enqueteservice.updateEnquete(EnqueteId, enquete);
    return ResponseEntity.ok(updatedEnquete);

  }

  @DeleteMapping("/{EnqueteId}")
  public ResponseEntity<String> deleteEnquete(@PathVariable Long EnqueteId) {
    boolean Enquetedeleted = enqueteservice.deleteEnquete(EnqueteId);
    if (Enquetedeleted) {
      return ResponseEntity.ok("Enquete was deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }

  }

}
