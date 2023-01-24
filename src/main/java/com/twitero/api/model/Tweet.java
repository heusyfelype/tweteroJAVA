package com.twitero.api.model;

import com.twitero.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Tweet {

  public Tweet(TweetDTO data) {
    this.username = data.username();
    this.tweet = data.tweet();
  }

  public Tweet() {

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String username;

  @Column(nullable = false)
  private String tweet;
}
