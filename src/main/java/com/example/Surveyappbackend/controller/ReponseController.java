package com.example.Surveyappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Surveyappbackend.dtos.ReponseDto;
import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.model.Repondant;
import com.example.Surveyappbackend.model.Reponse;
import com.example.Surveyappbackend.repository.RepondantRepository;
import com.example.Surveyappbackend.service.EnqueteService;
import com.example.Surveyappbackend.service.ReponseService;

/**
 * ReponseController
 */
@RestController()
@RequestMapping(path = "/api/responses/{EnqueteId}/{RespondantId}")
@CrossOrigin
public class ReponseController {
  @Autowired
  private ReponseService reponseService;
  @Autowired
  private EnqueteService enqueteService;
  @Autowired
  RepondantRepository repondantRepository;

  @PostMapping("/responses")
  public ResponseEntity<String> saveReponses(@PathVariable Long EnqueteId, @PathVariable Long RespondantId,
      @RequestBody List<ReponseDto> reponseList) {
    List<Question> questions = enqueteService.getQuestionsByEnquete(EnqueteId);
    Repondant repondant = repondantRepository.findById(RespondantId).orElse(null);
    try {
      for (int i = 0; i < reponseList.size(); i++) {
        Reponse reponse = new Reponse();
        Question question = questions.get(i);
        ReponseDto reponseDto = reponseList.get(i);
        reponse.setReponse(reponseDto.getReponse());
        reponse.setQuestion(question);
        reponse.setRepondant(repondant);
        reponseService.saveReponse(reponse);

      }

      return ResponseEntity.ok("Reponses saved successfully");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save responses");
    }
  }

}
