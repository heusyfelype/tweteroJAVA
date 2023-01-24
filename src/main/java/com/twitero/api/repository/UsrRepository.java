package com.twitero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitero.api.model.Usr;

public interface UsrRepository extends JpaRepository<Usr, Long> {

}
