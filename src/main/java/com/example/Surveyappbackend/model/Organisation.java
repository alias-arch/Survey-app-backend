package com.example.Surveyappbackend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Organisation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @Column(name = "nom")
  private String nom;
  @Column(name = "email")
  private String email;
  @Column(name = "ICE")
  private String ICE;

  @OneToMany(mappedBy = "organisation")
  private List<Enquete> enquetes = new ArrayList<>();

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
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

  public List<Enquete> getEnquetes() {
    return enquetes;
  }

  public void addEnquete(Enquete enquete) {
    this.enquetes.add(enquete);
  }
}
