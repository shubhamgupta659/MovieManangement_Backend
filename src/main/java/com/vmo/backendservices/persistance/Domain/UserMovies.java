package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_movies")
public class UserMovies {

    @EmbeddedId
    UserMovieKey id;

    @Column(name = "movie_rating")
    private Integer rating;

    @Column(name = "movie_review_title")
    private String reviewTitle;

    @Column(name = "movie_review")
    private String review;

    @Column(name = "is_movie_watch_listed")
    private boolean isWatchListed;
}
