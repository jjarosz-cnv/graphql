package com.graphql.repository;

import com.graphql.model.Director;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DirectorRepository {

    private List<Director> directors = new ArrayList<>();

    public Director findByName(String name) {
        return directors.stream()
                .filter(director -> director.fullName().equals(name))
                .findFirst().orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Director> findAll() {
        return directors;
    }

    public Director save(Director director) {
        Director directorToSave = new Director(directors.size()+ 1, director.getFirstName(), director.getLastName());
        directors.add(directorToSave);
        return directorToSave;
    }

    @PostConstruct
    private void init() {
        directors.add(new Director(1,"Richard","Marquand"));
        directors.add(new Director(2,"Quentin","Tarantino"));
        directors.add(new Director(3,"Luc","Besson"));
    }

}
