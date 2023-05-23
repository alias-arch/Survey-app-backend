package com.example.Surveyappbackend.dtos;

import java.util.List;

/**
 * ReponsesDto
 */
public class ReponsesDto {
  // private Long RepondantId;
  private List<ReponseDto> reponses;

  /*
   * public void setRepondantId(Long id) {
   * this.RepondantId = id;
   * }
   * 
   * public Long getRepondant() {
   * return this.RepondantId;
   * }
   */

  public void setReponses(List<ReponseDto> reponses) {
    this.reponses = reponses;
  }

  public List<ReponseDto> getReponses() {
    return this.reponses;
  }

}
