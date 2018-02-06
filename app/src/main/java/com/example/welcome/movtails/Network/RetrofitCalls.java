package com.example.welcome.movtails.Network;

import com.example.welcome.movtails.Network.Movie.GenresListResponse;
import com.example.welcome.movtails.Network.Movie.MovieCreditResponse;
import com.example.welcome.movtails.Network.Movie.MovieResponseCategorical;
import com.example.welcome.movtails.Network.Movie.MovieResponseFull;
import com.example.welcome.movtails.Network.TVShows.GenresListResponseTV;
import com.example.welcome.movtails.Network.TVShows.TVShowCreditResponse;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseCategorical;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseFull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by WELCOME on 03-12-2017.
 */

public interface RetrofitCalls {

    //MOVIES

    @GET("/movie/{id}/recommendations")
    Call<MovieResponseCategorical> getRecommendedMovies(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("movie/now_playing")
    Call<MovieResponseCategorical> getNowShowingMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/popular")
    Call<MovieResponseCategorical> getPopularMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/upcoming")
    Call<MovieResponseCategorical> getUpcomingMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/top_rated")
    Call<MovieResponseCategorical> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/{id}")
    Call<MovieResponseFull> getMovieDetails(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<VideoResponse> getMovieVideos(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/credits")
    Call<MovieCreditResponse> getMovieCredits(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/similar")
    Call<MovieResponseCategorical> getSimilarMovies(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("genre/movie/list")
    Call<GenresListResponse> getMovieGenresList(@Query("api_key") String apiKey);

    //TV SHOWS

    @GET("tv/airing_today")
    Call<TVShowResponseCategorical> getAiringTodayTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/on_the_air")
    Call<TVShowResponseCategorical> getOnTheAirTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/popular")
    Call<TVShowResponseCategorical> getPopularTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/top_rated")
    Call<TVShowResponseCategorical> getTopRatedTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/{id}")
    Call<TVShowResponseFull> getTVShowDetails(@Path("id") Integer tvShowId, @Query("api_key") String apiKey);

    @GET("tv/{id}/videos")
    Call<VideoResponse> getTVShowVideos(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("tv/{id}/credits")
    Call<TVShowCreditResponse> getTVShowCredits(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("tv/{id}/similar")
    Call<TVShowResponseCategorical> getSimilarTVShows(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("/tv/{id}/recommendations")
    Call<TVShowResponseCategorical> getRecommendedTVSHows(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("genre/tv/list")
    Call<GenresListResponseTV> getTVShowGenresList(@Query("api_key") String apiKey);

    //PERSON

    @GET("person/{id}")
    Call<PersonDetailsResponse> getPersonDetails(@Path("id") Integer personId, @Query("api_key") String apiKey);

    @GET("/person/{person_id}/combined_credits")
    Call<CombinedCreditsResponse> getCombinedCredits(@Path("id") Integer personId, @Query("api_key") String apiKey);



}
