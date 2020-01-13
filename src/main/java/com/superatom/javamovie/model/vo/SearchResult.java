package com.superatom.javamovie.model.vo;

import java.util.List;

public class SearchResult {
    private List<SearchMovie> movies;
    private List<CinemaInfo> cinemas;

    public List<SearchMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<SearchMovie> movies) {
        this.movies = movies;
    }

    public List<CinemaInfo> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<CinemaInfo> cinemas) {
        this.cinemas = cinemas;
    }
}
