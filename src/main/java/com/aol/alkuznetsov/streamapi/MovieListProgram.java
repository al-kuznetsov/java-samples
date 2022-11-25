package com.aol.alkuznetsov.streamapi;

import java.util.ArrayList;
import java.util.List;

public class MovieListProgram {

    public static void main(String[] args) {

        final List<Movie> movies = new ArrayList<>(7);
        movies.add(new Movie("Batman", "Tim Burton", 1989, 7.9));
        movies.add(new Movie("Batman Returns", "Tim Burton", 1992, 7.0));
        movies.add(new Movie("Batman Forever", "Joel Schumacher", 1995, 5.4));
        movies.add(new Movie("Batman & Robin", "Joel Schumacher", 1997, 3.7));
        movies.add(new Movie("Batman Begins", "Christopher Nolan", 2005, 8.3));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", 2007, 9.0));
        movies.add(new Movie("The Dark Knight Rises", "Christopher Nolan", 2012, 8.5));

        System.out.println("***");
        System.out.println("===>>> Imperative style");

        MovieList movieListImperative = new MovieListImperative();

        List<String> movieTitlesImperative = movieListImperative.getMovieTitles(movies);
        System.out.println("All Movie Titles: "
                + System.lineSeparator() + movieTitlesImperative);

        List<Movie> nolanMoviesImperative = movieListImperative.getNolanMovies(movies);
        System.out.println("Nolan Movie Titles: "
                + System.lineSeparator() + movieListImperative.getMovieTitles(nolanMoviesImperative));

        List<Movie> bestMoviesImperative = movieListImperative.getBestMovies(movies);
        System.out.println("Best Movie Titles: "
                + System.lineSeparator() + movieListImperative.getMovieTitles(bestMoviesImperative));

        double averageNolanRatingImperative = movieListImperative.getAverageRating(nolanMoviesImperative);
        System.out.println("Average Rating of Nolan movies"
                + System.lineSeparator() + averageNolanRatingImperative);

        List<Movie> moviesOlderThan2000Imperative = movieListImperative.getMoviesOlderThan2000(movies);
        System.out.println("Movies older than 2000: "
                + System.lineSeparator() + movieListImperative.getMovieTitles(moviesOlderThan2000Imperative));

        System.out.println("***");
        System.out.println("===>>> Functional style");

        MovieList movieListFunctional = new MovieListFunctional();

        List<String> movieTitlesFunctional = movieListFunctional.getMovieTitles(movies);
        System.out.println("All Movie Titles: "
                + System.lineSeparator() + movieTitlesFunctional);

        List<Movie> nolanMoviesFunctional = movieListFunctional.getNolanMovies(movies);
        System.out.println("Nolan Movie Titles: "
                + System.lineSeparator() + movieListFunctional.getMovieTitles(nolanMoviesFunctional));

        List<Movie> bestMoviesFunctional = movieListFunctional.getBestMovies(movies);
        System.out.println("Best Movie Titles: "
                + System.lineSeparator() + movieListFunctional.getMovieTitles(bestMoviesFunctional));

        double averageNolanRatingFunctional = movieListFunctional.getAverageRating(nolanMoviesFunctional);
        System.out.println("Average Rating of Nolan movies:"
                + System.lineSeparator() + averageNolanRatingFunctional);

        List<Movie> moviesOlderThan2000Functional = movieListFunctional.getMoviesOlderThan2000(movies);
        System.out.println("Movies older than 2000: "
                + System.lineSeparator() + movieListFunctional.getMovieTitles(moviesOlderThan2000Functional));
    }

}
