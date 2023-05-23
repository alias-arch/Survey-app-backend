package com.example.Surveyappbackend.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Enquete {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @Column(name = "description")
  private String description;
  @Column(name = "dateDebut")
  private Date dateDebut;
  @Column(name = "dateFin")
  private Date dateFin;
  @Column(name = "recievers")
  private String[] recievers;
  @Column(name = "sujet")
  private String sujet;
  @Column(name = "nomResp")
  private String nomResp;
  @OneToMany(mappedBy = "enquete", cascade = CascadeType.ALL)
  private List<Correspondance> correspondances = new ArrayList<>();

  /*
   * @OneToMany(mappedBy = "enquete", cascade = CascadeType.ALL)
   * private List<Question> questions = new ArrayList<>();
   */
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "organisation_id", referencedColumnName = "Id")
  private Organisation organisation;

  /*
   * 
   * @ManyToMany
   * private Repondant repondant;
   */
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

  /*
   * public List<Question> getQuestions() {
   * return questions;
   * }
   * 
   * public void setQuestions(List<Question> questions) {
   * this.questions = questions;
   * }
   * 
   * public void addQuestion(Question question) {
   * if (this.questions == null) {
   * this.questions = new ArrayList<>();
   * 
   * } else {
   * this.questions.add(question);
   * }
   * }
   */

  public Organisation getOrganisation() {
    return organisation;
  }

  public void setOrganisation(Organisation organisation) {
    if (this.organisation == null) {
      Organisation newOrg = new Organisation();
      newOrg.setICE(organisation.getICE());
      newOrg.setNom(organisation.getNom());
      newOrg.setEmail(organisation.getEmail());
      this.organisation = newOrg;

    }
    this.organisation = organisation;
  }
  /*
   * 
   * public Repondant getRepondant() {
   * return repondant;
   * }
   * 
   * public void setRepondant(Repondant repondant) {
   * this.repondant = repondant;
   * }
   */
}
