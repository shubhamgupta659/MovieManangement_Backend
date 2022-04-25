package com.vmo.backendservices.service;

import com.vmo.backendservices.dto.MovieInfoDTO;
import com.vmo.backendservices.dto.UserMovieInfo;
import com.vmo.backendservices.persistance.Domain.*;
import com.vmo.backendservices.persistance.Repository.MovieRepository;
import com.vmo.backendservices.persistance.Repository.UserMoviesRepository;
import com.vmo.backendservices.persistance.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<MovieInfoDTO> getLatestPicks(String username) {
        List<MovieInfoDTO> movieInfoDTOS = new ArrayList<>();
        movieRepository.findTop5forUser(username).stream().forEach(e->{
            Arrays.stream(e).forEach(System.out::print);
            MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
                BigInteger bigInteger = (BigInteger)e[0];
                BigInteger bigInteger1 = (BigInteger)e[9];
                movieInfoDTO.setMovieId(bigInteger.longValue());
                movieInfoDTO.setMovieName((String)e[7]);
                movieInfoDTO.setDescription((String)e[3]);
                movieInfoDTO.setGenre((String)e[5]);
                movieInfoDTO.setDirector((String)e[4]);
                movieInfoDTO.setLanguage((String)e[6]);
                movieInfoDTO.setYear((Integer)e[8]);
                movieInfoDTO.setCreatedBy((String)e[1]);
                movieInfoDTO.setCreatedDateTime((Timestamp)e[2]);
                List<DBFile> dbFiles = new ArrayList<>();
                DBFile dbFile = new DBFile();
                dbFile.setId(bigInteger1.longValue());
                dbFile.setData((byte[])e[10]);
                dbFile.setFileName((String)e[11]);
                dbFile.setFileType((String)e[12]);
                dbFile.setMovieInfo(null);
                dbFiles.add(dbFile);
                movieInfoDTO.setDbFiles(dbFiles);
                BigDecimal bigDecimal = (BigDecimal) e[15];
                BigDecimal bi = new BigDecimal("1");
                boolean bool = bigDecimal.equals(bi) ? true: false;
                movieInfoDTO.setMovieWatchListed(bool);
            movieInfoDTOS.add(movieInfoDTO);
        });
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return movieInfoDTOS;

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
        UserInfo userDetail = userRepository.findByUserName(auth.getName());
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
