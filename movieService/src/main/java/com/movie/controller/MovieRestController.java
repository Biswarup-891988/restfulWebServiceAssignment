package com.movie.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.model.MovieInfo;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieRestController {

  private final MovieService movieService;

  public MovieRestController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping(value = "/movie", produces = {"application/json", "application/xml", "text/xml"})
  public List<MovieInfo> getAllMovies() {
    List<MovieInfo> movieList = movieService.getAllMovieNames();
    return movieList;
  }

  @GetMapping(value = "/movie/{movieId}", produces = {"application/xml"})
  public ResponseEntity<MovieInfo> getMovieInfo(@PathVariable("movieId") String movieId) {
    Optional<MovieInfo> movie = movieService.getMovieById(movieId);
    if (movie.isPresent()) {
      return new ResponseEntity<>(movie.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

  }

}
