package com.example.welcome.movtails.Network.TVShows;

import java.util.ArrayList;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class TVShowResponseFull {

    private String backdrop_path;
    private ArrayList<Created> created_by;
    private ArrayList<Integer> episode_run_time;
    private String first_air_date;
    private ArrayList<GenreTV> genres;
    private String homepage;
    private Integer id;
    private Boolean in_production;
    private ArrayList<String> languages;
    private String last_air_date;
    private String name;
    private ArrayList<Networks> networks;
    private Integer number_of_episodes;
    private Integer number_of_seasons;
    private ArrayList<String> origin_country;
    private String original_language;
    private String original_name;
    private String overview;
    private Double popularity;
    private String poster_path;
    private ArrayList<ProductionCompanies> production_companies;
    private ArrayList<season> seasons;
    private String status;
    private String type;
    private Double vote_average;
    private Double vote_count;

    public TVShowResponseFull(String backdrop_path, ArrayList<Created> created_by, ArrayList<Integer> episode_run_time, String first_air_date, ArrayList<GenreTV> genres, String homepage, Integer id, Boolean in_production, ArrayList<String> languages, String last_air_date, String name, ArrayList<Networks> networks, Integer number_of_episodes, Integer number_of_seasons, ArrayList<String> origin_country, String original_language, String original_name, String overview, Double popularity, String poster_path, ArrayList<ProductionCompanies> production_companies, ArrayList<season> seasons, String status, String type, Double vote_average, Double vote_count) {
        this.backdrop_path = backdrop_path;
        this.created_by = created_by;
        this.episode_run_time = episode_run_time;
        this.first_air_date = first_air_date;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.in_production = in_production;
        this.languages = languages;
        this.last_air_date = last_air_date;
        this.name = name;
        this.networks = networks;
        this.number_of_episodes = number_of_episodes;
        this.number_of_seasons = number_of_seasons;
        this.origin_country = origin_country;
        this.original_language = original_language;
        this.original_name = original_name;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.seasons = seasons;
        this.status = status;
        this.type = type;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public ArrayList<Created> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(ArrayList<Created> created_by) {
        this.created_by = created_by;
    }

    public ArrayList<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(ArrayList<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public ArrayList<GenreTV> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GenreTV> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIn_production() {
        return in_production;
    }

    public void setIn_production(Boolean in_production) {
        this.in_production = in_production;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Networks> getNetworks() {
        return networks;
    }

    public void setNetworks(ArrayList<Networks> networks) {
        this.networks = networks;
    }

    public Integer getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(Integer number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public Integer getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(Integer number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public ArrayList<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(ArrayList<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ArrayList<ProductionCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<ProductionCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public ArrayList<season> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<season> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Double getVote_count() {
        return vote_count;
    }

    public void setVote_count(Double vote_count) {
        this.vote_count = vote_count;
    }

    private static class Created{

        private Integer id;
        private String name;
        private Integer gender;
        private String profile_path;

        public Created(Integer id, String name, Integer gender, String profile_path) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.profile_path = profile_path;
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

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }

    }

    private static class Networks{
        private Integer id;
        private String name;

        public Networks(Integer id, String name) {
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

    private static class ProductionCompanies{

        String name;
        Integer id;

        public ProductionCompanies(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    private static class season{

        private String air_date;
        private Integer episode_count;
        private Integer id;
        private String poster_path;
        private Integer season_number;

        public season(String air_date, Integer episode_count, Integer id, String poster_path, Integer season_number) {
            this.air_date = air_date;
            this.episode_count = episode_count;
            this.id = id;
            this.poster_path = poster_path;
            this.season_number = season_number;
        }

        public String getAir_date() {
            return air_date;
        }

        public void setAir_date(String air_date) {
            this.air_date = air_date;
        }

        public Integer getEpisode_count() {
            return episode_count;
        }

        public void setEpisode_count(Integer episode_count) {
            this.episode_count = episode_count;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public Integer getSeason_number() {
            return season_number;
        }

        public void setSeason_number(Integer season_number) {
            this.season_number = season_number;
        }
    }

}
