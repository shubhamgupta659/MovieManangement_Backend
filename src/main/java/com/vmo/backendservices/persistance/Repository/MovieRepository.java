package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieDetails, Long> {

    @Query("SELECT e.language,count(*) FROM MovieDetails e GROUP BY e.language ORDER BY e.language ASC")
    List<Object[]> findLanguageWithCounts();

    @Query("Select m.movieName from MovieDetails m where id = :movieId ")
    String findMovieById(@Param("movieId") Integer id);

    @Query(value = "SELECT movie_name FROM movie_details order by movie_name ASC LIMIT 5",nativeQuery = true)
    List<Object> searchMovie();

    @Query(value = "SELECT movie_name FROM movie_details where movie_name like %:searchKey% order by movie_name ASC LIMIT 5",nativeQuery = true)
    List<Object> searchMovieByKeyword(@Param("searchKey") String key);

}