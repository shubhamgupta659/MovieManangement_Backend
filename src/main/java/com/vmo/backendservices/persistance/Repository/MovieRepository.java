package com.vmo.backendservices.persistance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vmo.backendservices.persistance.Domain.MovieDetails;

@Repository
public interface MovieRepository extends JpaRepository<MovieDetails, Integer>{
	
	
	
	@Query("Select m.movieName from MovieDetails m where id = :movieId ")
	String findMovieById(@Param("movieId") Integer id);

}