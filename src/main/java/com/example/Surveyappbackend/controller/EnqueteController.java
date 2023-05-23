package com.example.Surveyappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Surveyappbackend.dtos.EnqueteWithOrganisation;
import com.example.Surveyappbackend.model.Enquete;
import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.service.EnqueteService;
import com.example.Surveyappbackend.service.QuestionService;

@RestController
@RequestMapping(path = "/api/Enquete")
public class EnqueteController {

  @Autowired
  private EnqueteService enqueteservice;
  @Autowired
  private QuestionService questionService;

  @GetMapping
  public ResponseEntity<List<EnqueteWithOrganisation>> getEnquetes() {
    return ResponseEntity.ok(this.enqueteservice.getEnquetes());
  }

  @GetMapping("/{EnqueteId}")
  public ResponseEntity<EnqueteWithOrganisation> getEnquete(@PathVariable Long EnqueteId) {
    return ResponseEntity.ok(this.enqueteservice.getEnquete(EnqueteId));
  }

  @PostMapping
  public ResponseEntity<Enquete> saveEnquete(@RequestBody Enquete enquete) {
    Enquete savedEnquete = this.enqueteservice.saveEnquete(enquete);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedEnquete);

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

  @GetMapping("/{EnqueteId}/questions")
  public ResponseEntity<List<Question>> getQuestionsByEnquete(@PathVariable Long EnqueteId) {
    return ResponseEntity.ok(enqueteservice.getQuestionsByEnquete(EnqueteId));
  }

  @PostMapping("/{EnqueteId}/questions")
  public ResponseEntity<List<Question>> saveQuestions(@PathVariable Long EnqueteId,
      @RequestBody List<Question> questions) {
    return ResponseEntity.ok(questionService.saveQuestions(EnqueteId, questions));

  }

}
