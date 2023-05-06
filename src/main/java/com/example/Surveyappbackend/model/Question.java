package com.example.Surveyappbackend.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "isPrivate")
    private boolean isPrivate;
    @Column(name = "qcmValues")
    private String[] qcmValues;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "createdBy")
    private String createdBy;

    @OneToOne
    @JoinColumn(name = "type_id", referencedColumnName = "Id")
    private Type type;
    @ManyToOne
    private Enquete enquete;
    @OneToMany
    private Reponse reponse;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        this.type = type;
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
