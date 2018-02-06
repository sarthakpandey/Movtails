package com.example.welcome.movtails.Network.TVShows;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class TVShowCreditResponse {

    private Integer id;
    private ArrayList<TVShowCast> cast;
    private ArrayList<TVShowCrew> crew;

    public TVShowCreditResponse(Integer id, ArrayList<TVShowCast> cast, ArrayList<TVShowCrew> crew) {
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

    public ArrayList<TVShowCast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<TVShowCast> cast) {
        this.cast = cast;
    }

    public ArrayList<TVShowCrew> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<TVShowCrew> crew) {
        this.crew = crew;
    }
}
