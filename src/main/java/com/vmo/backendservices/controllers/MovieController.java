package com.vmo.backendservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.backendservices.persistance.Domain.MovieDetails;
import com.vmo.backendservices.service.MovieDetailsService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieDetailsService movieDetailsService;
		
	@GetMapping("/findMovies")
	public List<MovieDetails> listUser(){
	    return movieDetailsService.findAll();
	}

	@RequestMapping(value = "/insertMovie", method = RequestMethod.POST)
	public MovieDetails create(@RequestBody MovieDetails movieDetails){
	    return movieDetailsService.save(movieDetails);
	}

	@RequestMapping(value = "/findMovies/{id}", method = RequestMethod.GET)
	public Optional<MovieDetails> findOne(@PathVariable Integer id){
	    return movieDetailsService.findOne(id);
	}

	@RequestMapping(value = "/updateMovie/{id}", method = RequestMethod.PUT)
	public MovieDetails update(@PathVariable Integer id, @RequestBody MovieDetails movieDetails){
		movieDetails.setMovieId(id);
	    return movieDetailsService.save(movieDetails);
	}

	@RequestMapping(value = "/removeMovie/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id){
		movieDetailsService.delete(id);
	}
	}
