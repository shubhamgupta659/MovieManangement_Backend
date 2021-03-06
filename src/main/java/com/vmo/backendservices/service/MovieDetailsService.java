package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.MovieInfo;

import java.util.List;
import java.util.Optional;

public interface MovieDetailsService {

    List<MovieInfo> findAll();

    List<MovieInfo> getLatestPicks();

    MovieInfo save(MovieInfo movieInfo);

    Optional<MovieInfo> findOne(Long id);

    void delete(Long id);

    List<Object[]> getCountGroupByLanguage();

    List<Object[]> searchMovie();

    List<Object[]> searchMovieByKeyword(String key);
}
