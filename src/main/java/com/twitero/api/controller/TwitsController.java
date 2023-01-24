package com.twitero.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  public ResponseEntity<String> create(@RequestBody TweetDTO req) {
    service.create(req);
    return ResponseEntity.ok().body("ok");
  }
}
