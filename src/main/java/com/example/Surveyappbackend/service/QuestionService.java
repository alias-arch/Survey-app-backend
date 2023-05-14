package com.example.Surveyappbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.repository.QuestionRepository;

/**
 * QuestionService
 */
public class QuestionService {
  @Autowired
  QuestionRepository questionRepository;

  public Question getQuestionById(Long questionId) {
    Optional<Question> optionalQuestion = questionRepository.findById(questionId);
    return optionalQuestion.get();

  }

  public void createQuestion(Question question) {
    questionRepository.save(question);

  }

}
