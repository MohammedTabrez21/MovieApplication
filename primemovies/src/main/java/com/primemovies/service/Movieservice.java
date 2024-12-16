package com.primemovies.service;

import java.util.List;

import com.primemovies.entity.movies;


public interface Movieservice {
	
	public String addmovie(movies mov);
	public List<movies> viewmovies();

}
