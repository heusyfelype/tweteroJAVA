package com.twitero.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.twitero.api.dto.UsrDTO;
import com.twitero.api.model.Usr;
import com.twitero.api.repository.UsrRepository;

@Service
public class UsrService {

  @Autowired
  private UsrRepository repository;

  public void create(@RequestBody UsrDTO req) {
    repository.save(new Usr(req));
  }

  public List<Usr> findAllUsers() {
    return repository.findAll();
  }
}
