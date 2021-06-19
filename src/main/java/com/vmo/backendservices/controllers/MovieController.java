package com.vmo.backendservices.controllers;

import com.vmo.backendservices.persistance.Domain.MovieDetails;
import com.vmo.backendservices.service.MovieDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieDetailsService movieDetailsService;

    @GetMapping("/findMovies")
    public List<MovieDetails> listUser() {
        return movieDetailsService.findAll();
    }

    @RequestMapping(value = "/insertMovie", method = RequestMethod.POST)
    public MovieDetails create(@RequestBody MovieDetails movieDetails) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        movieDetails.setCreatedBy(auth.getName());
        movieDetails.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
        return movieDetailsService.save(movieDetails);
    }

    @RequestMapping(value = "/findMovies/{id}", method = RequestMethod.GET)
    public Optional<MovieDetails> findOne(@PathVariable Long id) {
        return movieDetailsService.findOne(id);
    }

    @RequestMapping(value = "/updateMovie/{id}", method = RequestMethod.PUT)
    public MovieDetails update(@PathVariable Long id, @RequestBody MovieDetails movieDetails) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        movieDetails.setMovieId(id);
        movieDetails.setCreatedBy(auth.getName());
        movieDetails.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
        return movieDetailsService.save(movieDetails);
    }

    @RequestMapping(value = "/removeMovie/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        movieDetailsService.delete(id);
    }

    @RequestMapping(value = "/countByLanguage", method = RequestMethod.GET)
    public List<Object[]> getCountGroupByLanguage() {
        return movieDetailsService.getCountGroupByLanguage();
    }

    @RequestMapping(value = "/searchByKey/", method = RequestMethod.GET)
    public List<Object> searchMovie() {
        return movieDetailsService.searchMovie();
    }

    @RequestMapping(value = "/searchByKey/{key}", method = RequestMethod.GET)
    public List<Object> searchMovieByKeyword(@PathVariable(value = "key") String key) {
        return movieDetailsService.searchMovieByKeyword(key);
    }
}
