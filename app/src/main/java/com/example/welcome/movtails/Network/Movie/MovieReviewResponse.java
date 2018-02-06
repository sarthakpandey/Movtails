package com.example.welcome.movtails.Network.Movie;

import java.util.ArrayList;

/**
 * Created by WELCOME on 03-12-2017.
 */

public class MovieReviewResponse {

    private Integer id;
    private Integer page;
    private ArrayList<ReviewBody> results;
    private Integer total_pages;
    private Integer total_results;

    public MovieReviewResponse(Integer id, Integer page, ArrayList<ReviewBody> results, Integer total_pages, Integer total_results) {
        this.id = id;
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ArrayList<ReviewBody> getResults() {
        return results;
    }

    public void setResults(ArrayList<ReviewBody> results) {
        this.results = results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public static class ReviewBody{

        String author;
        String content;
        String url;

        public ReviewBody(String author, String content, String url) {
            this.author = author;
            this.content = content;
            this.url = url;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
