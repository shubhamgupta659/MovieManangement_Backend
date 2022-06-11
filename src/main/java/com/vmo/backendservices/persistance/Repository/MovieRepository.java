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

    @Query(value = "SELECT * FROM movie_info order by movie_name ASC LIMIT 5",nativeQuery = true)
    List<Object[]> searchMovie();

    @Query(value = "SELECT * FROM movie_info where movie_name like %:searchKey% order by movie_name ASC LIMIT 5",nativeQuery = true)
    List<Object[]> searchMovieByKeyword(@Param("searchKey") String key);

    List<MovieInfo> findByCreatedBy(String createdBy);

    @Query(value = "SELECT * FROM movie_info order by movie_year DESC LIMIT 5",nativeQuery = true)
    List<MovieInfo> findTop5();

    @Query(value= "select mif.*,IFNULL(um.umi.is_movie_watch_listed,0) as is_movie_watch_listed from (select mi.*,f.*, row_number() over(partition by mi.movie_id order by mi.movie_id) num\n" +
            "from movie_management.movie_info mi \n" +
            "join movie_management.movie_info_db_files midf on mi.movie_id=midf.movie_info_movie_id \n" +
            "join movie_management.files f on midf.db_files_file_id=f.file_id order by movie_year desc limit 5) mif\n" +
            "left join (select um.movie_id,um.is_movie_watch_listed from movie_management.user_movies um\n" +
            "join movie_management.user_info ui on um.user_id=ui.user_id where ui.user_name= :searchKey ) umi\n" +
            "on mif.movie_id= umi.movie_id",nativeQuery = true)
    List<Object[]> findTop5forUser(@Param("searchKey")String username);

    @Query(value= "select mif.*,IFNULL(um.umi.is_movie_watch_listed,0) as is_movie_watch_listed from (select mi.*,f.*, row_number() over(partition by mi.movie_id order by mi.movie_id) num\n" +
            "            from movie_management.user_movies um \n" +
            "            join movie_management.movie_info mi on mi.movie_id=um.movie_id \n" +
            "            join movie_management.movie_info_db_files midf on mi.movie_id=midf.movie_info_movie_id \n" +
            "            join movie_management.files f on midf.db_files_file_id=f.file_id group by um.movie_id order by count(*) desc limit 5) mif\n" +
            "            left join (select um.movie_id,um.is_movie_watch_listed from movie_management.user_movies um\n" +
            "            join movie_management.user_info ui on um.user_id=ui.user_id where ui.user_name= 'nimish001' ) umi\n" +
            "            on mif.movie_id= umi.movie_id",nativeQuery = true)
    List<Object[]> findTop5PopularPicksforUser(@Param("searchKey")String username);
}