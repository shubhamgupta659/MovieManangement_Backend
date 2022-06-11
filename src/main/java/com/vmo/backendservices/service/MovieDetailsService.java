package com.vmo.backendservices.service;

import com.vmo.backendservices.dto.MovieInfoDTO;
import com.vmo.backendservices.dto.UserMovieInfo;
import com.vmo.backendservices.persistance.Domain.MovieInfo;
import com.vmo.backendservices.persistance.Domain.UserMovies;

import java.util.List;
import java.util.Optional;

public interface MovieDetailsService {

    List<MovieInfo> findAll();

    List<MovieInfoDTO> getLatestPicks(String username);

    List<MovieInfoDTO> getPopularPicks(String username);

    MovieInfo save(MovieInfo movieInfo);

    Optional<MovieInfo> findOne(Long id);

    void delete(Long id);

    List<Object[]> getCountGroupByLanguage();

    List<Object[]> searchMovie();

    List<Object[]> searchMovieByKeyword(String key);

    UserMovieInfo getMovieRatingForUser(Long key);

    UserMovies saveMovieRatingForUser(UserMovieInfo movieInfo);
}
