package com.example.welcome.movtails.Network;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class CombinedCreditsResponse {

    private ArrayList<CombinedCreditCast> cast;
    private ArrayList<CombinedCreditCrew> crew;
    private Integer id;

    public CombinedCreditsResponse(ArrayList<CombinedCreditCast> cast, ArrayList<CombinedCreditCrew> crew, Integer id) {
        this.cast = cast;
        this.crew = crew;
        this.id = id;
    }

    public ArrayList<CombinedCreditCast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<CombinedCreditCast> cast) {
        this.cast = cast;
    }

    public ArrayList<CombinedCreditCrew> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<CombinedCreditCrew> crew) {
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
