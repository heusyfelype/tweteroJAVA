package com.twitero.api.model;

import com.twitero.api.dto.UsrDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usr {

  public Usr(UsrDTO data) {
    this.username = data.username();
    this.avatar = data.avatar();
  }
  public Usr(){
    
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String username;

  @Column(nullable = false)
  private String avatar;
}
