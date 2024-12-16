package com.primemovies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.primemovies.entity.entity;
import com.primemovies.repository.repository;

@Service
public class implementation implements services {
	
	repository repo;
	

	public implementation(repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String createcustomer(entity e) {
		repo.save(e);
		return "object created successfully";
	}

	@Override
	public boolean checkemail(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkpass(String email, String password) {
		entity user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(db_pass.equals(password)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public List<entity> viewUser() {
		List<entity> userlist= repo.findAll();
		return userlist;
	}

	@Override
	public entity getuser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(entity e) {
		repo.save(e);
	}

	@Override
	public boolean userExists(String email) {
		if(repo.findByEmail(email)!=null) {
			return true;
		}else
		return false;
	
	}

}
