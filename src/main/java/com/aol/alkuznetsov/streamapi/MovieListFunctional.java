package com.aol.alkuznetsov.streamapi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is an example of the functional style programming.
 * Mostly Java Stream API demo.
 */
public class MovieListFunctional implements MovieList {

    @Override
    public List<String> getMovieTitles(List<Movie> movies) {
        return movies.stream().map(Movie::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getNolanMovies(List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getDirector().equals("Christopher Nolan")).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getBestMovies(List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getImdbRating() > 7.5).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesOlderThan2000(List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getYear() < 2000).collect(Collectors.toList());
    }

    @Override
    public double getAverageRating(List<Movie> movies) {
        //return movies.stream().map(Movie::getImdbRating).reduce(Double::sum).orElse(0.0) / movies.size();
        double total = movies.stream().mapToDouble(Movie::getImdbRating).sum();
        return total / movies.size();
    }
}
