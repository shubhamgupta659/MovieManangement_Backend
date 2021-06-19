package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.MovieDetails;
import com.vmo.backendservices.persistance.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieDetailsServiceImpl implements MovieDetailsService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDetails> findAll() {
        return movieRepository.findAll();
    }

    public MovieDetails save(MovieDetails movieDetails) {
        return movieRepository.save(movieDetails);
    }

    public Optional<MovieDetails> findOne(Long id) {
        return movieRepository.findById(id);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Object[]> getCountGroupByLanguage() {
        List<Object[]> results = movieRepository.findLanguageWithCounts();
        return results;
    }

    public List<Object> searchMovie() {
        List<Object> results = movieRepository.searchMovie();
        return results;
    }

    public List<Object> searchMovieByKeyword(String key) {
        List<Object> results = movieRepository.searchMovieByKeyword(key);
        return results;
    }
}
