package com.graphql.repository;

import com.graphql.model.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private final DirectorRepository directorRepository;

    public MovieRepository(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    private List<Movie> movies = new ArrayList<>();

    public List<Movie> findAll() {
        return movies;
    }

    public Movie findOne(Integer id) {
        return movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @PostConstruct
    private void init() {
        movies.add(new Movie(1,
                "Return of the Jedi",
                132,
                directorRepository.findByName("Richard Marquand")));
        movies.add(new Movie(2,
                "Pulp Fiction",
                154,
                directorRepository.findByName("Quentin Tarantino")));
        movies.add(new Movie(3,
                "Leon the Professional",
                110,
                directorRepository.findByName("Luc Besson")));
    }

}
