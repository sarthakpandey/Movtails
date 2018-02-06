package com.example.welcome.movtails.Network;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class CombinedCreditCast {

    private Integer id;
    private String original_language;
    private Integer episode_count;
    private String overview;
    private ArrayList<String> origin_country;
    private String original_name;
    private ArrayList<Integer> genre_ids;
    private String name;
    private String media_type;
    private String poster_path;
    private String first_air_date;
    private Double vote_average;
    private Integer vote_count;
    private String       character;
    private String backdrop_path;
    private Double popularity;
    private String credit_id;
    private String original_title;
    private Boolean video;
    private String release_date;
    private String title;
    private Boolean adult;

    public CombinedCreditCast(Integer id, String original_language, Integer episode_count, String overview, ArrayList<String> origin_country, String original_name, ArrayList<Integer> genre_ids, String name, String media_type, String poster_path, String first_air_date, Double vote_average, Integer vote_count, String character, String backdrop_path, Double popularity, String credit_id, String original_title, Boolean video, String release_date, String title, Boolean adult) {
        this.id = id;
        this.original_language = original_language;
        this.episode_count = episode_count;
        this.overview = overview;
        this.origin_country = origin_country;
        this.original_name = original_name;
        this.genre_ids = genre_ids;
        this.name = name;
        this.media_type = media_type;
        this.poster_path = poster_path;
        this.first_air_date = first_air_date;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.character = character;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.credit_id = credit_id;
        this.original_title = original_title;
        this.video = video;
        this.release_date = release_date;
        this.title = title;
        this.adult = adult;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public Integer getEpisode_count() {
        return episode_count;
    }

    public String getOverview() {
        return overview;
    }

    public ArrayList<String> getOrigin_country() {
        return origin_country;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public String getName() {
        return name;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public String getCharacter() {
        return character;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public Boolean getVideo() {
        return video;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setEpisode_count(Integer episode_count) {
        this.episode_count = episode_count;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setOrigin_country(ArrayList<String> origin_country) {
        this.origin_country = origin_country;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }
}
