package com.graphql.controller;

import com.graphql.model.Director;
import com.graphql.repository.DirectorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Controller
public class DirectorController {

    private DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @QueryMapping
    public List<Director> allDirectors() {
        return directorRepository.findAll();
    }

    @MutationMapping(name = "createDirector")
    public Director saveDirector(@Argument(name = "directorToSave") Director director) {
        return directorRepository.save(director);
    }

    @SubscriptionMapping
    public Flux<List<Director>> directorListUpdate() {
        return Flux.interval(Duration.ofSeconds(2))
                .flatMap(ignore -> {
                    Director newDirector = new Director(null, "John", "Doe");
                    directorRepository.save(newDirector);
                    return Flux.just(directorRepository.findAll());
                })
                .take(Duration.ofSeconds(20));
    }
}
