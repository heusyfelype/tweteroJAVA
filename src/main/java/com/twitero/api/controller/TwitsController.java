package com.twitero.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitero.api.dto.TweetDTO;
import com.twitero.api.service.TweetsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/tweets")
public class TwitsController {
  @Autowired
  TweetsService service;

  @PostMapping
  public void create(@RequestBody TweetDTO req){
    service.create(req);
  }
}
