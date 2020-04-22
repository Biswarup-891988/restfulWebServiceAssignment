package com.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo {

  private String movieId;
  private String movieName;
  private String movieActor;
  private Double movieCollection;

}
