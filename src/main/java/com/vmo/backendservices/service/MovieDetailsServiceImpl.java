package com.vmo.backendservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmo.backendservices.persistance.Domain.MovieDetails;
import com.vmo.backendservices.persistance.Repository.MovieRepository;
@Service
@Transactional
public class MovieDetailsServiceImpl implements MovieDetailsService {
	
	@Autowired
	private MovieRepository movieRepository;

	public List<MovieDetails> findAll(){
		return movieRepository.findAll();
	}
	
	public MovieDetails save(MovieDetails movieDetails) {
		return movieRepository.save(movieDetails);
	}
	
	public Optional<MovieDetails> findOne(Integer id){
		return movieRepository.findById(id);
	}
	
	public void delete(Integer id) {
		movieRepository.deleteById(id);
	}
}
