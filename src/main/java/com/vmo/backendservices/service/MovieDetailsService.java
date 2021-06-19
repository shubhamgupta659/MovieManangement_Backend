package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.MovieDetails;

import java.util.List;
import java.util.Optional;

public interface MovieDetailsService {

    List<MovieDetails> findAll();

    MovieDetails save(MovieDetails movieDetails);

    Optional<MovieDetails> findOne(Long id);

    void delete(Long id);

    List<Object[]> getCountGroupByLanguage();

    List<Object> searchMovie();

    List<Object> searchMovieByKeyword(String key);
}
