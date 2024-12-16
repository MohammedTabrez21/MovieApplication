package com.primemovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.primemovies.entity.movies;
import com.primemovies.service.Movieservice;

@Controller
public class movie {
	@Autowired
	Movieservice moserv;
	
	
	public movie(Movieservice moserv) {
		super();
		this.moserv = moserv;
	}

@PostMapping("add-movies")
	public String addmovie(@ModelAttribute movies mov) {
		moserv.addmovie(mov);
		return "movieaddedsuccessfully";
	}

@GetMapping("veiwmovie")
public String viewmovies(Model model) {
	List<movies> movieLists=moserv.viewmovies();
	model.addAttribute("movies", movieLists);
	return "viewmovies";
}

@GetMapping("viewusermovies")
public String viewusermovies(Model model) {
	List<movies> movieLists=moserv.viewmovies();
	model.addAttribute("movies", movieLists);
	return "viewusermovies";
}
}
