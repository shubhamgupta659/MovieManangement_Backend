package com.vmo.backendservices.persistance.Domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString
@Table(name = "movie_info")
public class MovieInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id", updatable = false, nullable = false)
    private Long movieId;

    @NotEmpty(message = "Movie name can not be empty")
    @Column(name = "movie_name")
    private String movieName;

    @NotEmpty(message = "Movie description can not be empty")
    @Column(name = "movie_description")
    private String description;

    @NotEmpty(message = "Movie Genre can not be empty")
    @Column(name = "movie_genre")
    private String genre;

    @NotEmpty(message = "Movie Director can not be empty")
    @Column(name = "movie_director")
    private String director;

    @NotEmpty(message = "Movie Language can not be empty")
    @Column(name = "movie_language")
    private String language;

    @NotNull(message = "Movie Year can not be empty")
    @Column(name = "movie_year")
    private Integer year;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date_time")
    private Timestamp createdDateTime;

    @OneToMany(fetch = FetchType.EAGER)
    private List<DBFile> dbFiles;
}
