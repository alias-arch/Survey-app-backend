package com.example.Surveyappbackend.dtos;

/**
 * ReponseDto
 */
public class ReponseDto {
  private Long questionId;
  private String reponse;

  public void setQuestionId(Long id) {
    this.questionId = id;
  }

  public Long getQuestionId() {
    return this.questionId;
  }

  public void setReponse(String reponse) {
    this.reponse = reponse;
  }

  public String getReponse() {
    return this.reponse;
  }

}
