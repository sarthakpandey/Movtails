package com.example.welcome.movtails.Network.TVShows;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class TVShowResponseCategorical {

    private Integer page;
    private ArrayList<TVShowResponseGeneral> results;
    private Integer total_results;
    private Integer total_pages;

    public TVShowResponseCategorical(Integer page, ArrayList<TVShowResponseGeneral> results, Integer total_results, Integer total_pages) {
        this.page = page;
        this.results = results;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ArrayList<TVShowResponseGeneral> getResults() {
        return results;
    }

    public void setResults(ArrayList<TVShowResponseGeneral> results) {
        this.results = results;
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
}
