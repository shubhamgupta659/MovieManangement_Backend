package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "movie_details")
public class MovieDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id", updatable = false, nullable = false)
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_rating")
    private String rating;

    @Column(name = "movie_language")
    private String language;

    @Column(name = "movie_year")
    private Integer year;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date_time")
    private Timestamp createdDateTime;
}
