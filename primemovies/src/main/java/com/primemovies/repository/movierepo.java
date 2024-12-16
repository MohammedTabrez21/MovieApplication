package com.primemovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primemovies.entity.movies;

public interface movierepo extends JpaRepository<movies, Integer>{

}
