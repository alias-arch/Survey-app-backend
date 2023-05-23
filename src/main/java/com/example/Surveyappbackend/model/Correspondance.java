package com.example.Surveyappbackend.model;

import javax.persistence.*;

@Entity
public class Correspondance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @ManyToOne
  @JoinColumn(name = "enquete_id")
  private Enquete enquete;
  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public Enquete getEnquete() {
    return enquete;
  }

  public void setEnquete(Enquete enquete) {
    this.enquete = enquete;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }
}
