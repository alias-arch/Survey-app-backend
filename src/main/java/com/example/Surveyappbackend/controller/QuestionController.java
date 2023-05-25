package com.example.Surveyappbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.service.QuestionService;
import java.util.List;

/**
 * QuestionController
 */
@RestController
@RequestMapping(path = "/api/Enquete/Question")
@CrossOrigin
public class QuestionController {
  @Autowired
  private QuestionService questionService;

  @GetMapping
  public ResponseEntity<List<Question>> getQuestions() {
    return ResponseEntity.ok(questionService.getQuestions());

  }

  @GetMapping("/{QuestionId}")
  public ResponseEntity<Question> getQuestion(@PathVariable Long QuestionId) {
    return ResponseEntity.ok(questionService.getQuestion(QuestionId));
  }

  @PostMapping("/{EnqueteId}")
  public ResponseEntity<Question> createQuestion(@PathVariable Long EnqueteId, @RequestBody Question question) {
    return ResponseEntity.ok(questionService.createQuestion(EnqueteId, question));

  }

  @PutMapping("/{EnqueteId}/{QuestionId}")
  public ResponseEntity<Question> updateQuestion(@PathVariable Long EnqueteId, @PathVariable Long QuestionId,
      @RequestBody Question question) {
    return ResponseEntity.ok(questionService.updateQuestion(EnqueteId, QuestionId, question));
  }

  @DeleteMapping("/{QuestionId}")
  public ResponseEntity<String> deleteQuestion(@PathVariable Long QuestionId) {
    return ResponseEntity.ok(questionService.deleteQuestion(QuestionId));
  }
}
