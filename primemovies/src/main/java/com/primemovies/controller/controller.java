package com.primemovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.primemovies.entity.entity;
import com.primemovies.entity.movies;
import com.primemovies.service.Movieservice;
import com.primemovies.service.services;

import jakarta.persistence.Table;
import jakarta.servlet.http.HttpSession;

@Controller
@Table(name="user")
public class controller {
	@Autowired
	services serv;
	@Autowired
	Movieservice movser;
	
	public controller(services serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping("register")
	public String createcustomer(@ModelAttribute entity e) {
		boolean status=serv.checkemail(e.getEmail());
		
		if(status==true) {
			return "registeralready";
		}
		else {
		serv.createcustomer(e);
		System.err.println("Already exist");
		}
		return "successfull";
	}
	
	@PostMapping("login")
	
	public  String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
	if(serv.userExists(email)){
	boolean loginstatus=serv.checkpass(email, password);
	if(loginstatus==true) {
		session.setAttribute("email",	email);
		if(email.equals("admin@gmail.com")&& password.equals("admin@123")) {
			return "adminhome";
		}
		else {
		return "home";
		}
	}
	else {
		return "fail";
	}
}
else {
	session.setAttribute("errorMessage", "User not found. Please register.");
    return "fail";
}
}
	@GetMapping("veiwuser")
public String viewUser(Model model) {
	List<entity> userList=serv.viewUser();
	model.addAttribute("entity" ,userList);
	return "viewusers";
}

@GetMapping("exploreMovie")
public String exploreMovies(Model model, HttpSession session){

	String email = (String)session.getAttribute("email");
	
	entity email1=serv.getuser(email);
	boolean status = email1.isPremium();
	
	if(status == true)
	{
		List<movies> movieLists=movser.viewmovies();
		model.addAttribute("movies", movieLists);
		return "viewusermovies";
	}
	else
	{
		return "payment";
	}
}

	@GetMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}

}




