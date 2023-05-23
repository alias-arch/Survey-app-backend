package com.example.Surveyappbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Surveyappbackend.dtos.EnqueteWithOrganisation;
import com.example.Surveyappbackend.model.Correspondance;
import com.example.Surveyappbackend.model.Enquete;
import com.example.Surveyappbackend.model.Organisation;
import com.example.Surveyappbackend.model.Question;
import com.example.Surveyappbackend.repository.CorresRepository;
import com.example.Surveyappbackend.repository.EnqueteRepository;

/**
 * EnqueteService
 */
@Service
public class EnqueteService {
  @Autowired
  private EnqueteRepository enqueteRepository;
  @Autowired
  private CorresRepository corresRepository;

  public List<EnqueteWithOrganisation> getEnquetes() {
    List<Enquete> enquetes = enqueteRepository.findAll();
    List<EnqueteWithOrganisation> enquetesDtos = new ArrayList<>();
    for (Enquete enquete : enquetes) {
      Organisation organisation = enquete.getOrganisation();
      EnqueteWithOrganisation enqueteWithOrganisation = new EnqueteWithOrganisation();
      enqueteWithOrganisation.setRecievers(enquete.getRecievers());
      enqueteWithOrganisation.setNomResp(enquete.getNomResp());
      enqueteWithOrganisation.setDateDebut(enquete.getDateDebut());
      enqueteWithOrganisation.setDateFin(enquete.getDateFin());
      enqueteWithOrganisation.setSujet(enquete.getSujet());
      enqueteWithOrganisation.setDescription(enquete.getDescription());
      enqueteWithOrganisation.setICE(organisation.getICE());
      enqueteWithOrganisation.setNom(organisation.getNom());
      enqueteWithOrganisation.setEmail(organisation.getEmail());
      enquetesDtos.add(enqueteWithOrganisation);

    }
    return enquetesDtos;

  }

  public EnqueteWithOrganisation getEnquete(Long EnqueteId) {
    Enquete enquete = enqueteRepository.findById(EnqueteId).orElse(null);
    if (enquete != null) {
      Organisation organisation = enquete.getOrganisation();
      EnqueteWithOrganisation enqueteWithOrganisation = new EnqueteWithOrganisation();
      enqueteWithOrganisation.setRecievers(enquete.getRecievers());
      enqueteWithOrganisation.setNomResp(enquete.getNomResp());
      enqueteWithOrganisation.setDateDebut(enquete.getDateDebut());
      enqueteWithOrganisation.setDateFin(enquete.getDateFin());
      enqueteWithOrganisation.setSujet(enquete.getSujet());
      enqueteWithOrganisation.setDescription(enquete.getDescription());
      enqueteWithOrganisation.setICE(organisation.getICE());
      enqueteWithOrganisation.setNom(organisation.getNom());
      enqueteWithOrganisation.setEmail(organisation.getEmail());
      return enqueteWithOrganisation;
    } else {
      return null;
    }

  }

  public Enquete saveEnquete(Enquete enquete) {
    Enquete enquete2 = enqueteRepository.save(enquete);
    return enquete2;

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
    Enquete existingEnquete = enqueteRepository.findById(EnqueteId).orElse(null);
    existingEnquete.setDescription(updatedEnquete.getDescription());
    existingEnquete.setSujet(updatedEnquete.getSujet());
    existingEnquete.setDateFin(updatedEnquete.getDateFin());
    existingEnquete.setDateDebut(updatedEnquete.getDateDebut());
    existingEnquete.setNomResp(updatedEnquete.getNomResp());
    existingEnquete.setOrganisation(updatedEnquete.getOrganisation());
    existingEnquete.setRecievers(updatedEnquete.getRecievers());
    return enqueteRepository.save(existingEnquete);

  }

  public List<Question> getQuestionsByEnquete(Long EnqueteId) {
    Enquete enquete = enqueteRepository.findById(EnqueteId).orElse(null);
    List<Correspondance> correspondences = corresRepository.findByEnquete(enquete);
    if (!correspondences.isEmpty()) {
      List<Question> questions = new ArrayList<>();

      for (Correspondance correspondence : correspondences) {
        questions.add(correspondence.getQuestion());
      }

      return questions;
    } else {
      return null;
    }
  }

}
