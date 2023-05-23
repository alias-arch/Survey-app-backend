package com.example.Surveyappbackend.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  @Column(name = "titre")
  private String titre;
  @Column(name = "isPrivate")
  private boolean isPrivate;
  @Column(name = "qcmValues")
  private String[] qcmValues;
  @Column(name = "createdAt")
  private Date createdAt;
  @Column(name = "createdBy")
  private String createdBy;
  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
  private List<Correspondance> correspondances = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "type_id", referencedColumnName = "Id")
  private Type type;
  /*
   * @ManyToOne(cascade = CascadeType.ALL)
   * 
   * @JoinColumn(name = "enquete_id", referencedColumnName = "Id")
   * private Enquete enquete;
   */
  @OneToMany(mappedBy = "question")
  private List<Reponse> reponses = new ArrayList<>();

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getTitre() {
    return this.titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public boolean isPrivate() {
    return isPrivate;
  }

  public void setPrivate(boolean aPrivate) {
    isPrivate = aPrivate;
  }

  public String[] getQcmValues() {
    return qcmValues;
  }

  public void setQcmValues(String[] qcmValues) {
    this.qcmValues = qcmValues;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    if (this.type == null) {
      Type newType = new Type();
      newType.setLabel(type.getLabel());
      newType.setDescription(type.getDescription());
      this.type = newType;

    }
    this.type = type;
  }

  /*
   * public Enquete getEnquete() {
   * return enquete;
   * }
   * 
   * public void setEnquete(Enquete enquete) {
   * this.enquete = enquete;
   * }
   */

  public List<Reponse> getReponses() {
    return reponses;
  }

  public void setReponse(Reponse reponse) {
    this.reponses.add(reponse);
  }

  public String toString() {
    return "{id : " + Id + ",description: " + createdBy + "}";

  }
}
