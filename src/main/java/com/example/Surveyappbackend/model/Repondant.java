package com.example.Surveyappbackend.model;


import javax.persistence.*;
@Entity
public class Repondant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "email")
    private String email;
    @Column(name = "organisme")
    private String organisme;

    @ManyToMany
    private Enquete enquete;
    @OneToOne
    private Reponse reponse;

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

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }
}
