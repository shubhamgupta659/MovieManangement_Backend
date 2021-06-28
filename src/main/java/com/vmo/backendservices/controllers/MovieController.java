package com.vmo.backendservices.controllers;

import com.vmo.backendservices.dto.UploadFileResponse;
import com.vmo.backendservices.persistance.Domain.DBFile;
import com.vmo.backendservices.persistance.Domain.MovieInfo;
import com.vmo.backendservices.service.DBFileStorageService;
import com.vmo.backendservices.service.MovieDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieDetailsService movieDetailsService;

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @GetMapping("/findMovies")
    public List<MovieInfo> listUser() {
        return movieDetailsService.findAll();
    }

    @GetMapping("/latestPicks")
    public List<MovieInfo> getLatestPicks() {
        return movieDetailsService.getLatestPicks();
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public UploadFileResponse create(@RequestParam("file") MultipartFile file, @RequestParam("movieName") String movieName,
                                     @RequestParam("description") String description, @RequestParam("genre") String genre,
                                     @RequestParam("director") String director, @RequestParam("language") String language,
                                     @RequestParam("year") String year) {
        DBFile dbFile = dbFileStorageService.storeFile(file);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setMovieName(movieName);
        movieInfo.setDescription(description);
        movieInfo.setGenre(genre);
        movieInfo.setDirector(director);
        movieInfo.setLanguage(language);
        movieInfo.setYear(Integer.parseInt(year));
        movieInfo.setCreatedBy(auth.getName());
        movieInfo.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
        List<DBFile> dbFiles = new ArrayList<>();
        dbFiles.add(dbFile);
        movieInfo.setDbFiles(dbFiles);
        MovieInfo movieInfo1 = movieDetailsService.save(movieInfo);
        //DBFile dbFile = dbFileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId()+"")
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/findMovies/{id}", method = RequestMethod.GET)
    public Optional<MovieInfo> findOne(@PathVariable Long id) {
        return movieDetailsService.findOne(id);
    }

    @RequestMapping(value = "/updateMovie/{id}", method = RequestMethod.PUT)
    public UploadFileResponse update(@PathVariable Long id, @RequestParam("file") MultipartFile file, @RequestParam("movieName") String movieName,
                            @RequestParam("description") String description, @RequestParam("genre") String genre,
                            @RequestParam("director") String director, @RequestParam("language") String language,
                            @RequestParam("year") String year) {
        DBFile dbFile = dbFileStorageService.storeFile(file);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setMovieId(id);
        movieInfo.setMovieName(movieName);
        movieInfo.setDescription(description);
        movieInfo.setGenre(genre);
        movieInfo.setDirector(director);
        movieInfo.setLanguage(language);
        movieInfo.setYear(Integer.parseInt(year));
        movieInfo.setCreatedBy(auth.getName());
        movieInfo.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
        List<DBFile> dbFiles = new ArrayList<>();
        dbFiles.add(dbFile);
        movieInfo.setDbFiles(dbFiles);
        MovieInfo movieInfo1 = movieDetailsService.save(movieInfo);
        //DBFile dbFile = dbFileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId()+"")
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/removeMovie/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        movieDetailsService.delete(id);
    }

    @RequestMapping(value = "/countByLanguage", method = RequestMethod.GET)
    public List<Object[]> getCountGroupByLanguage() {
        return movieDetailsService.getCountGroupByLanguage();
    }

    @RequestMapping(value = "/searchByKey/", method = RequestMethod.GET)
    public List<Object[]> searchMovie() {
        return movieDetailsService.searchMovie();
    }

    @RequestMapping(value = "/searchByKey/{key}", method = RequestMethod.GET)
    public List<Object[]> searchMovieByKeyword(@PathVariable(value = "key") String key) {
        return movieDetailsService.searchMovieByKeyword(key);
    }
}
