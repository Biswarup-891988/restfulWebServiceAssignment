package com.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.movie.model.MovieInfo;

public class MovieService {

  private List<MovieInfo> movieInfoList;

  public MovieService() {

    this.movieInfoList = new ArrayList<>();
    movieInfoList.add(new MovieInfo("M001", "Top Gun", "Tom Cruise", 3500000.00));
    movieInfoList.add(new MovieInfo("M002", "John Wick", "Keaunu Reves", 380000.00));
    movieInfoList.add(new MovieInfo("M003", "Die Hard", "Bruce Wills", 1500000.00));
    movieInfoList.add(new MovieInfo("M004", "Avatar", "Sam Arthur", 6500000.00));
    movieInfoList.add(new MovieInfo("M005", "Iron man", "Robert Downey Jr", 4000000.00));
    movieInfoList.add(new MovieInfo("M006", "Seven", "Brad pitt", 4500000.00));
    movieInfoList.add(new MovieInfo("M007", "Titanic", "Leanardo Di caprio", 5500000.00));
    movieInfoList.add(new MovieInfo("M008", "Vice", "Christian Bale", 1400000.00));
    movieInfoList.add(new MovieInfo("M009", "Wolverine", "Huge Jackman", 2700000.00));
  }

  public List<MovieInfo> getAllMovieNames() {
    return this.movieInfoList;
  }

  public Optional<MovieInfo> getMovieById(String movieId) {
    return movieInfoList.stream().filter(m -> m.getMovieId().equalsIgnoreCase(movieId))
        .findFirst();
  }

}
