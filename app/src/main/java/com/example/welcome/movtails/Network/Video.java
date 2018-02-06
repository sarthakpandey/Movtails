package com.example.welcome.movtails.Network;

import java.util.ArrayList;

/**
 * Created by WELCOME on 03-12-2017.
 */

public class Video {

    private Integer id;
    private ArrayList<VideoResponse> results;

    public Video(Integer id, ArrayList<VideoResponse> results) {
        this.id = id;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<VideoResponse> getResults() {
        return results;
    }

    public void setResults(ArrayList<VideoResponse> results) {
        this.results = results;
    }
}
