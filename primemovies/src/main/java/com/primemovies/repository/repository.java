package com.primemovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primemovies.entity.entity;

public interface repository extends JpaRepository<entity, Integer> 
{
	public entity findByEmail(String email);

}
