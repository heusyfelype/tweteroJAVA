package com.twitero.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.twitero.api.dto.TweetDTO;
import com.twitero.api.model.Tweet;
import com.twitero.api.repository.TweetRepository;

@Service
public class TweetsService {
  List<Tweet> tweets;

  @Autowired
  private TweetRepository repository;

  public void create(@RequestBody TweetDTO req) {
    repository.save(new Tweet(req));
  }

}
