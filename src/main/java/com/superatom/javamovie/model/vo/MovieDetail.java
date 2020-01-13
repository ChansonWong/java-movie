package com.superatom.javamovie.model.vo;

import java.util.List;

public class MovieDetail {
    private List<CinemaInfo> cinemas;

    public List<CinemaInfo> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<CinemaInfo> cinemas) {
        this.cinemas = cinemas;
    }
}
