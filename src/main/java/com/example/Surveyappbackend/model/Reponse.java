package com.example.Surveyappbackend.model;

import javax.persistence.*;
@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "reponse")
    private String reponse;

    @OneToOne
    @JoinColumn(name = "repondant_id", referencedColumnName = "Id")
    private Repondant repondant;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "Id")
    private Question question;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Repondant getRepondant() {
        return repondant;
    }

    public void setRepondant(Repondant repondant) {
        this.repondant = repondant;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
