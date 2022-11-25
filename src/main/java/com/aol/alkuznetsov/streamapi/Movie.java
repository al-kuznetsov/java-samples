package com.aol.alkuznetsov.streamapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Movie {

    private String title;

    private String director;

    private int year;

    private double imdbRating;
}
