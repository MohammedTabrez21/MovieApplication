package com.primemovies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.primemovies.entity.movies;
import com.primemovies.repository.movierepo;

@Service
public class Movieimplements implements  Movieservice{

	movierepo repo;
	
	public Movieimplements(movierepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addmovie(movies mov) {
		repo.save(mov);
		return "movie added successfully";
	}

	@Override
	public List<movies> viewmovies() {
		List<movies> movieList=repo.findAll();
		return movieList;
	}

}
