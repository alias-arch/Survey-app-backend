package com.example.Surveyappbackend.model;

import javax.persistence.*;
import java.util.Date;

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

    @OneToMany
    @JoinColumn(name = "question_id", referencedColumnName = "Id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "organisation_id", referencedColumnName = "Id")
    private Organisation organisation;
    @ManyToMany
    private Repondant repondant;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Repondant getRepondant() {
        return repondant;
    }

    public void setRepondant(Repondant repondant) {
        this.repondant = repondant;
    }
}
