package com.example.Surveyappbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Surveyappbackend.model.Reponse;
import com.example.Surveyappbackend.repository.ReponseRepository;

/**
 * ReponseService
 */
@Service
public class ReponseService {
  @Autowired
  private ReponseRepository reponseRepository;

  public void saveReponse(Reponse reponse) {
    reponseRepository.save(reponse);

  }

}
