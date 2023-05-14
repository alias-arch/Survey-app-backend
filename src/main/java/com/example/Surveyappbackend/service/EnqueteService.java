package com.example.Surveyappbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Surveyappbackend.model.Enquete;
import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.repository.EnqueteRepository;

/**
 * EnqueteService
 */
public class EnqueteService {
  @Autowired
  private EnqueteRepository enqueteRepository;
  @Autowired
  private QuestionService questionService;

  public List<Enquete> getEnquetes() {
    return enqueteRepository.findAll();

  }

  public Enquete getEnquete(Long EnqueteId) {
    Optional<Enquete> optionalEnquete = enqueteRepository.findById(EnqueteId);
    if (optionalEnquete.isPresent()) {
      return optionalEnquete.get();
    }
    return null;

  }

  public void saveEnquete(Enquete enquete) {
    enqueteRepository.save(enquete);

  }

  public boolean deleteEnquete(Long EnqueteId) {
    Enquete existingEnquete = enqueteRepository.findById(EnqueteId).orElse(null);
    if (existingEnquete != null) {
      enqueteRepository.delete(existingEnquete);
      return true;

    } else {
      return false;
    }

  }

  public Enquete updateEnquete(Long EnqueteId, Enquete updatedEnquete) {
    Optional<Enquete> optionalexistingEnquete = enqueteRepository.findById(EnqueteId);
    if (!optionalexistingEnquete.isPresent()) {
      return null;

    }
    Enquete existingEnquete = optionalexistingEnquete.get();
    for (Question existingquestion : existingEnquete.getQuestions()) {
      if (!updatedEnquete.getQuestions().contains(existingquestion)) {
        existingEnquete.getQuestions().remove(existingquestion);

      }

    }
    for (Question updatedquestion : updatedEnquete.getQuestions()) {
      Question existingQuestion = questionService.getQuestionById(updatedquestion.getId());
      if (existingQuestion != null) {
        existingQuestion.setType(updatedquestion.getType());
        existingQuestion.setEnquete(updatedquestion.getEnquete());
        existingQuestion.setPrivate(updatedquestion.isPrivate());
        existingQuestion.setCreatedAt(updatedquestion.getCreatedAt());
        existingQuestion.setCreatedBy(updatedquestion.getCreatedBy());
        existingQuestion.setQcmValues(updatedquestion.getQcmValues());

      } else {
        Question newQuestion = new Question();
        newQuestion.setType(updatedquestion.getType());
        newQuestion.setEnquete(updatedquestion.getEnquete());
        newQuestion.setPrivate(updatedquestion.isPrivate());
        newQuestion.setCreatedAt(updatedquestion.getCreatedAt());
        newQuestion.setCreatedBy(updatedquestion.getCreatedBy());
        newQuestion.setQcmValues(updatedquestion.getQcmValues());
        questionService.createQuestion(newQuestion);
        existingEnquete.getQuestions().add(newQuestion);

      }

    }
    return enqueteRepository.save(existingEnquete);

  }

}
