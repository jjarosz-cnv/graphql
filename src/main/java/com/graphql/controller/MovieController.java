package com.graphql.controller;

import com.graphql.model.Movie;
import com.graphql.repository.MovieRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @SchemaMapping(typeName = "query")
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    @QueryMapping
    public Movie findOneMovie(@Argument(name = "id") Integer number) {
        return movieRepository.findOne(number);
    }
}