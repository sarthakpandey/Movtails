package com.example.welcome.movtails.Network.TVShows;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class GenresListResponseTV {

    private ArrayList<GenreTV> genres;

    public GenresListResponseTV(ArrayList<GenreTV> genres) {
        this.genres = genres;
    }

    public ArrayList<GenreTV> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GenreTV> genres) {
        this.genres = genres;
    }
}
