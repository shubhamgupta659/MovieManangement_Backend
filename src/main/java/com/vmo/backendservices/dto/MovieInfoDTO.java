package com.vmo.backendservices.dto;

import com.vmo.backendservices.persistance.Domain.DBFile;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
public class MovieInfoDTO implements Serializable {

    private Long movieId;
    private String movieName;
    private String description;
    private String genre;
    private String director;
    private String language;
    private Integer year;
    private String createdBy;
    private Timestamp createdDateTime;
    private List<DBFile> dbFiles;
    private boolean isMovieWatchListed;
    private String userName;

}
