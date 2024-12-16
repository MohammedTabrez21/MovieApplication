package com.primemovies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class movies {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String moviename;
	@Column(length=2000)
	String movieLink;
	String movieGenre;
	String movieCast;
	String MovieDirector;
	public movies() {
		super();
		
	}
	public movies(int id, String moviename, String movieLink, String movieGenre, String movieCast,
			String movieDirector) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.movieLink = movieLink;
		this.movieGenre = movieGenre;
		this.movieCast = movieCast;
		MovieDirector = movieDirector;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMovieLink() {
		return movieLink;
	}
	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieCast() {
		return movieCast;
	}
	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}
	public String getMovieDirector() {
		return MovieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		MovieDirector = movieDirector;
	}
	@Override
	public String toString() {
		return "movies [id=" + id + ", moviename=" + moviename + ", movieLink=" + movieLink + ", movieGenre="
				+ movieGenre + ", movieCast=" + movieCast + ", MovieDirector=" + MovieDirector + "]";
	}
	

}
