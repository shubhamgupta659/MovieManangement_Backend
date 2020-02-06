package com.vmo.backendservices.service;

import java.util.List;
import java.util.Optional;

import com.vmo.backendservices.persistance.Domain.MovieDetails;

public interface MovieDetailsService {

	List<MovieDetails> findAll();
	
	MovieDetails save(MovieDetails movieDetails);
	
	Optional<MovieDetails> findOne(Integer id);
	
	void delete(Integer id);
}
