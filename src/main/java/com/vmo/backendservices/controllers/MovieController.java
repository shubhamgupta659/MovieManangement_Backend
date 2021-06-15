package com.vmo.backendservices.controllers;

import com.vmo.backendservices.persistance.Domain.MovieDetails;
import com.vmo.backendservices.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return movieDetailsService.save(movieDetails);
    }

    @RequestMapping(value = "/findMovies/{id}", method = RequestMethod.GET)
    public Optional<MovieDetails> findOne(@PathVariable Long id) {
        return movieDetailsService.findOne(id);
    }

    @RequestMapping(value = "/updateMovie/{id}", method = RequestMethod.PUT)
    public MovieDetails update(@PathVariable Long id, @RequestBody MovieDetails movieDetails) {
        movieDetails.setMovieId(id);
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
}
