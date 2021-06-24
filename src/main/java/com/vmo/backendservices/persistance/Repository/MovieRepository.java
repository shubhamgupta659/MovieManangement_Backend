package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieInfo, Long> {

    @Query("SELECT e.language,count(*) FROM MovieInfo e WHERE createdBy =:username GROUP BY e.language ORDER BY e.language ASC")
    List<Object[]> findLanguageWithCounts(@Param("username") String username);

    @Query("Select m.movieName from MovieInfo m where id = :movieId ")
    String findMovieById(@Param("movieId") Integer id);

    @Query(value = "SELECT movie_name FROM movie_info order by movie_name ASC LIMIT 5",nativeQuery = true)
    List<Object> searchMovie();

    @Query(value = "SELECT movie_name FROM movie_info where movie_name like %:searchKey% order by movie_name ASC LIMIT 5",nativeQuery = true)
    List<Object> searchMovieByKeyword(@Param("searchKey") String key);

    List<MovieInfo> findByCreatedBy(String createdBy);
}