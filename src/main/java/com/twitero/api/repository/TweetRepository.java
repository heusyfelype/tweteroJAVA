package com.twitero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitero.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
