package com.example.welcome.movtails.Network.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class GenresListResponse {

    private ArrayList<Genre> genres;

    public GenresListResponse(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }
}
