package com.twitero.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitero.api.dto.UsrDTO;
import com.twitero.api.model.Usr;
import com.twitero.api.service.UsrService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sign-up")
public class UsrController {
  @Autowired
  private UsrService service;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody UsrDTO req) {
    service.create(req);
    return ResponseEntity.ok().body("ok");
  }
  @GetMapping
  public ResponseEntity<List<Usr>> users(){
    var users = service.findAllUsers();
    if(users != null){
      return ResponseEntity.ok().body(users);
    }
   return ResponseEntity.badRequest().build();
  }

}
