package com.primemovies.service;

import java.util.List;

import com.primemovies.entity.entity;

public interface services {
	
public String createcustomer(entity e);
public boolean checkemail(String email);
public boolean checkpass(String email, String password);
public List<entity> viewUser();
public entity getuser(String email);
public void updateUser(entity e);
public boolean userExists(String email);

}
	