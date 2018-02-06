package com.example.welcome.movtails.Network.TVShows;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class GenreTV {

    private Integer id;
    private String name;

    public GenreTV(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
