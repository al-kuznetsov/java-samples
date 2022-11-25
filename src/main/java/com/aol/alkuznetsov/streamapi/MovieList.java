package com.aol.alkuznetsov.streamapi;

import java.util.List;

public interface MovieList {

    List<String> getMovieTitles(List<Movie> movies);

    List<Movie> getNolanMovies(List<Movie> movies);

    List<Movie> getBestMovies(List<Movie> movies);

    List<Movie> getMoviesOlderThan2000(List<Movie> movies);

    double getAverageRating(List<Movie> movies);
}
