package com.graphql.model;

public class Movie {
        private int id;
        private String title;
        private Integer time;
        private Director director;


    public Movie(Integer id, String title, Integer time, Director director) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }
}
