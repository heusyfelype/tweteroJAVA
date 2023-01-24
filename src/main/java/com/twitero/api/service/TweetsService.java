package com.twitero.api.service;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
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

  public Page<Tweet> findTweets(Pageable pageable) {
    int page = pageable.getPageNumber();
    int size = 5;

    PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "Id");

    return new PageImpl<>(
      repository.findAll(),
      pageRequest,
      size
      );
  }
}
