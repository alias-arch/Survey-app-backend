package com.example.Surveyappbackend.dtos;

import java.util.Date;

/**
 * EnqueteWithOrganisation
 */
public class EnqueteWithOrganisation {

  private Long Id;
  private String description;
  private Date dateDebut;
  private Date dateFin;
  private String[] recievers;
  private String sujet;
  private String nomResp;
  private String nom;
  private String email;
  private String ICE;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String[] getRecievers() {
    return recievers;
  }

  public void setRecievers(String[] recievers) {
    this.recievers = recievers;
  }

  public String getSujet() {
    return sujet;
  }

  public void setSujet(String sujet) {
    this.sujet = sujet;
  }

  public String getNomResp() {
    return nomResp;
  }

  public void setNomResp(String nomResp) {
    this.nomResp = nomResp;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getICE() {
    return ICE;
  }

  public void setICE(String ICE) {
    this.ICE = ICE;
  }
}
