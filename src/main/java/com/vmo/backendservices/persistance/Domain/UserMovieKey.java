package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserMovieKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "movie_id")
    private Long movieId;
}