package com.example.welcome.movtails.Network.Movie;

import java.util.ArrayList;

/**
 * Created by WELCOME on 03-12-2017.
 */

public class MovieResponseCategorical {

    private Integer page;
    private Integer total_results;
    private Integer total_pages;
    private ArrayList<MovieResponseGeneral> results;

    public MovieResponseCategorical(Integer page, Integer total_results, Integer total_pages, ArrayList<MovieResponseGeneral> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<MovieResponseGeneral> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieResponseGeneral> results) {
        this.results = results;
    }
}
