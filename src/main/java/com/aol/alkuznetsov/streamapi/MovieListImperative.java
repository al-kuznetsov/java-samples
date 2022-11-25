package com.aol.alkuznetsov.streamapi;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an example of imperative style programming, but still using advice:
 * Use constant variables whenever possible.
 * Split program into functions.
 * The next step is using pure functions, that do not mutate the program state - almost functional programming.
 * Favor use of pure functions that accept parameters and do not access the program state.
 */
public class MovieListImperative implements MovieList {

    public List<String> getMovieTitles(List<Movie> movies) {

        List<String> movieTitles = new ArrayList<>();

        for (Movie tempMovie : movies) {
            movieTitles.add(tempMovie.getTitle());
        }

        return movieTitles;
    }

    public List<Movie> getNolanMovies(List<Movie> movies) {
        List<Movie> nolanMovies = new ArrayList<>();
        for (Movie tempMovie : movies) {
            if (tempMovie.getDirector().equals("Christopher Nolan")) {
                nolanMovies.add(tempMovie);
            }
        }
        return nolanMovies;
    }

    public List<Movie> getBestMovies(List<Movie> movies) {
        List<Movie> bestMovies = new ArrayList<>();
        for (Movie tempMovie : movies) {
            double highImdbRating = 7.5;
            if (tempMovie.getImdbRating() > highImdbRating) {
                bestMovies.add(tempMovie);
            }
        }
        return bestMovies;
    }

    public List<Movie> getMoviesOlderThan2000(List<Movie> movies) {
        List<Movie> moviesOlderThan2000 = new ArrayList<>();
        for (Movie tempMovie : movies) {
            if (tempMovie.getYear() < 2000) {
                moviesOlderThan2000.add(tempMovie);
            }
        }
        return moviesOlderThan2000;
    }

    public double getAverageRating(List<Movie> movies) {
        if (movies == null || movies.isEmpty()) {
            throw new IllegalArgumentException("The non-empty movie list must be provided");
        }
        double total = 0;
        for (Movie tempMovie : movies) {
            total += tempMovie.getImdbRating();
        }
        return total / movies.size();
    }

}
