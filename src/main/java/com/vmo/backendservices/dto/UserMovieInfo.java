package com.vmo.backendservices.dto;

import lombok.Data;

@Data
public class UserMovieInfo {
    private Long movieId;
    private Long userId;
    private Integer rating;
    private String reviewTitle;
    private String review;
    private boolean watchListed;
}
