package com.example.welcome.movtails.Network.Movie;

import java.util.ArrayList;

/**
 * Created by WELCOME on 03-12-2017.
 */

public class MovieCreditResponse {

    private Integer id;
    private ArrayList<MovieCast> cast;
    private ArrayList<MovieCrew> crew;

    public MovieCreditResponse(Integer id, ArrayList<MovieCast> cast, ArrayList<MovieCrew> crew) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<MovieCast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<MovieCast> cast) {
        this.cast = cast;
    }

    public ArrayList<MovieCrew> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<MovieCrew> crew) {
        this.crew = crew;
    }
}
