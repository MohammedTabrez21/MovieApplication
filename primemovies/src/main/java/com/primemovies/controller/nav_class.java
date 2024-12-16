package com.primemovies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class nav_class {
	
	@GetMapping("map_register")
	public String map_register() {
		return "firstpage1";
	}
	
	@GetMapping("map_login")
	public String maplogin() {
		return "login";
	}
	
	@GetMapping("map-addmovie")
	public String mapMovies() {
		return "addmovies";
	}
	
	@GetMapping("map_addmovies")
	public String mapaddmovie() {
		return "addmovies";
	}

}
