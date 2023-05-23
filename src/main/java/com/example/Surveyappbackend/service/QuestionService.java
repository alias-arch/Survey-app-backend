package com.example.Surveyappbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Surveyappbackend.model.Correspondance;
import com.example.Surveyappbackend.model.Enquete;
import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.repository.CorresRepository;
import com.example.Surveyappbackend.repository.EnqueteRepository;
import com.example.Surveyappbackend.repository.QuestionRepository;

/**
 * QuestionService
 */
@Service
public class QuestionService {
  @Autowired
  QuestionRepository questionRepository;
  @Autowired
  EnqueteRepository enqueteRepository;
  @Autowired
  CorresRepository corresRepository;

  public Question getQuestion(Long questionId) {
    Optional<Question> optionalQuestion = questionRepository.findById(questionId);
    return optionalQuestion.orElse(null);

  }

  public Question createQuestion(Long EnqueteId, Question question) {
    Enquete enquete = enqueteRepository.findById(EnqueteId).orElse(null);
    Question createdQuestion = questionRepository.save(question);
    Correspondance correspondance = new Correspondance();
    correspondance.setEnquete(enquete);
    correspondance.setQuestion(question);
    corresRepository.save(correspondance);
    return createdQuestion;

  }

  public List<Question> getQuestions() {
    return questionRepository.findAll();

  }

  public Question updateQuestion(Long EnqueteId, Long questionId, Question updatedQuestion) {
    Question question = questionRepository.findById(questionId).orElse(null);
    System.out.println("question to update: " + question);
    Enquete enquete = enqueteRepository.findById(EnqueteId).orElse(null);
    if (enquete != null && question != null) {
      question.setType(updatedQuestion.getType());
      question.setTitre(updatedQuestion.getTitre());
      question.setPrivate(updatedQuestion.isPrivate());
      question.setCreatedAt(updatedQuestion.getCreatedAt());
      question.setCreatedBy(updatedQuestion.getCreatedBy());
      question.setQcmValues(updatedQuestion.getQcmValues());
      return questionRepository.save(question);

    } else {
      return null;

    }

  }

  public String deleteQuestion(Long questionId) {
    Question question = questionRepository.findById(questionId).orElse(null);
    if (question != null) {
      questionRepository.delete(question);
      return "question with Id :" + questionId + "was deleted";

    } else {
      return "error : question was not deleted";

    }

  }

  public List<Question> saveQuestions(Long EnqueteId, List<Question> questions) {
    Enquete enquete = enqueteRepository.findById(EnqueteId).orElse(null);
    List<Question> savedQuestions = new ArrayList<>();
    for (Question question : questions) {
      Question createdQuestion = questionRepository.save(question);
      Correspondance correspondance = new Correspondance();
      correspondance.setEnquete(enquete);
      correspondance.setQuestion(question);
      corresRepository.save(correspondance);
      savedQuestions.add(createdQuestion);

    }
    return savedQuestions;

  }

}
