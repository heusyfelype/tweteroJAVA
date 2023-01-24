package com.twitero.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitero.api.dto.TweetDTO;
import com.twitero.api.model.Tweet;
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

  @GetMapping
  public ResponseEntity<List<Tweet>> tweets(@PageableDefault(page = 0, size = 5) Pageable page) {
    var infos = service.findTweets(page).getContent();
    if(!infos.isEmpty()){
      return ResponseEntity.ok().body(infos);
    }
    return ResponseEntity.notFound().build();
  }

  // @GetMapping
  // public <Tweet> tweets(@PageableDefault(page = 0, size = 5) Pageable page) {
  //   return service.findTweets(page);
  //   // var infos = pageInfos.getContent();
  //   // if(!infos.isEmpty()){
  //   //   return ResponseEntity.ok().body(infos);
  //   // }
  //   // return ResponseEntity.notFound().build();
  // }
}
