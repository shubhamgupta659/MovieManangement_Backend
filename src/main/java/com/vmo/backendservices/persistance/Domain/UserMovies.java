package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_movies")
public class UserMovies {

    @EmbeddedId
    UserMovieKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_Id")
    UserInfo userInfo;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    RoleInfo roleInfo;

    @Column(name = "movie_rating")
    private Double rating;

    @Column(name = "movie_review_title")
    private String reviewTitle;

    @Column(name = "movie_review")
    private String review;
}
