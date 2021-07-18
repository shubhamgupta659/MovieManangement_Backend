package com.vmo.backendservices.service;

import com.vmo.backendservices.dto.UserMovieInfo;
import com.vmo.backendservices.persistance.Domain.MovieInfo;
import com.vmo.backendservices.persistance.Domain.UserInfo;
import com.vmo.backendservices.persistance.Domain.UserMovieKey;
import com.vmo.backendservices.persistance.Domain.UserMovies;
import com.vmo.backendservices.persistance.Repository.MovieRepository;
import com.vmo.backendservices.persistance.Repository.UserMoviesRepository;
import com.vmo.backendservices.persistance.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class MovieDetailsServiceImpl implements MovieDetailsService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMoviesRepository userMoviesRepository;

    public List<MovieInfo> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return movieRepository.findByCreatedBy(auth.getName());
    }

    public List<MovieInfo> getLatestPicks() {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return movieRepository.findTop5();
    }

    public MovieInfo save(MovieInfo movieInfo) {
        return movieRepository.save(movieInfo);
    }

    public Optional<MovieInfo> findOne(Long id) {
        return movieRepository.findById(id);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Object[]> getCountGroupByLanguage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Object[]> results = movieRepository.findLanguageWithCounts(auth.getName());
        return results;
    }

    public List<Object[]> searchMovie() {
        List<Object[]> results = movieRepository.searchMovie();
        return results;
    }

    public List<Object[]> searchMovieByKeyword(String key) {
        List<Object[]> results = movieRepository.searchMovieByKeyword(key);
        return results;
    }

    public UserMovieInfo getMovieRatingForUser(Long key) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetail = userRepository.findByUsername(auth.getName());
        UserMovieKey userMovieKey = new UserMovieKey();
        userMovieKey.setMovieId(key);
        userMovieKey.setUserId(userDetail.getUserId());
        Optional<UserMovies> results = userMoviesRepository.findById(userMovieKey);
        UserMovieInfo userMovieInfo = new UserMovieInfo();
        if(results.isPresent()){
            userMovieInfo.setMovieId(results.get().getId().getMovieId());
            userMovieInfo.setUserId(results.get().getId().getUserId());
            userMovieInfo.setRating(results.get().getRating());
            userMovieInfo.setReview(results.get().getReview());
            userMovieInfo.setReviewTitle(results.get().getReviewTitle());
            userMovieInfo.setWatchListed(results.get().isWatchListed());
            return userMovieInfo;
        }else{
            userMovieInfo.setMovieId(key);
            userMovieInfo.setUserId(userDetail.getUserId());
            userMovieInfo.setRating(0);
            userMovieInfo.setReview(null);
            userMovieInfo.setReviewTitle(null);
            userMovieInfo.setWatchListed(false);
            return userMovieInfo;
        }
    }

    public UserMovies saveMovieRatingForUser(UserMovieInfo movieInfo) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //UserInfo userDetail = userRepository.findByUsername(auth.getName());
        UserMovieKey userMovieKey = new UserMovieKey();
        userMovieKey.setMovieId(movieInfo.getMovieId());
        userMovieKey.setUserId(movieInfo.getUserId());
        UserMovies userMovies = new UserMovies();
        userMovies.setId(userMovieKey);
        userMovies.setRating(movieInfo.getRating());
        userMovies.setReview(movieInfo.getReview());
        userMovies.setReviewTitle(movieInfo.getReviewTitle());
        userMovies.setWatchListed(movieInfo.isWatchListed());
        UserMovies results = userMoviesRepository.save(userMovies);
        return results;
    }
}
