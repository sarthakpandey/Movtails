package com.example.welcome.movtails.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.welcome.movtails.Adapters.MovieCustomAdapterTypeOne;
import com.example.welcome.movtails.Adapters.MovieCustomAdapterTypeThree;
import com.example.welcome.movtails.Adapters.MovieCustomAdapterTypeTwo;
import com.example.welcome.movtails.Constants;
import com.example.welcome.movtails.Network.Movie.GenresListResponse;
import com.example.welcome.movtails.Network.Movie.MovieGenreGiver;
import com.example.welcome.movtails.Network.Movie.MovieResponseCategorical;
import com.example.welcome.movtails.Network.Movie.MovieResponseGeneral;
import com.example.welcome.movtails.Network.RetrofitCalls;
import com.example.welcome.movtails.Network.RetrofitGiver;
import com.example.welcome.movtails.R;
import com.example.welcome.movtails.SeeMoreActivity;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private AVLoadingIndicatorView indicatorView;
    private LinearLayout visibilityLayout;

    private Boolean popularLoaded;
    private Boolean nowShowingLoaded;
    private Boolean topRatedLoaded;
    private Boolean upcomingLoaded;

    private CardView popular_see_more;
    private RecyclerView popular_recycler_view;
    private ArrayList<MovieResponseGeneral> popularMoviesList;
    private MovieCustomAdapterTypeTwo popularAdapter;

    private CardView now_showing_see_more;
    private RecyclerView now_showing_recycler_view;
    private ArrayList<MovieResponseGeneral> nowShowingMoviesList;
    private MovieCustomAdapterTypeOne nowShowingAdapter;

    private CardView top_rated_see_more;
    private RecyclerView top_rated_recycler_view;
    private ArrayList<MovieResponseGeneral> topRatedMoviesList;
    private MovieCustomAdapterTypeOne topRatedAdapter;

    private CardView upcoming_see_more;
    private RecyclerView upcoming_recycler_view;
    private ArrayList<MovieResponseGeneral> upcomingMoviesList;
    private MovieCustomAdapterTypeThree upcomingAdapter;



    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        popularLoaded = false;
        nowShowingLoaded = false;
        topRatedLoaded = false;
        upcomingLoaded = false;

        indicatorView = view.findViewById(R.id.avi_progress);
        visibilityLayout = view.findViewById(R.id.visibility_layout);

        visibilityLayout.setVisibility(View.GONE);
        indicatorView.show();

        popular_see_more = view.findViewById(R.id.popular_movies_see_more);
        popular_recycler_view = view.findViewById(R.id.popular_movies_recycler_view);
        (new LinearSnapHelper()).attachToRecyclerView(popular_recycler_view);
        popularMoviesList = new ArrayList<>();
        popularAdapter = new MovieCustomAdapterTypeTwo(getContext(),popularMoviesList);


        now_showing_see_more = view.findViewById(R.id.now_showing_movies_see_more);
        now_showing_recycler_view = view.findViewById(R.id.now_showing_movies_recycler_view);
        nowShowingMoviesList = new ArrayList<>();
        nowShowingAdapter = new MovieCustomAdapterTypeOne(getContext(),nowShowingMoviesList);



        top_rated_see_more = view.findViewById(R.id.top_rated_movies_see_more);
        top_rated_recycler_view = view.findViewById(R.id.top_rated_movies_recycler_view);
        topRatedMoviesList = new ArrayList<>();
        topRatedAdapter = new MovieCustomAdapterTypeOne(getContext(),topRatedMoviesList);



        upcoming_see_more = view.findViewById(R.id.upcoming_movies_see_more);
        upcoming_recycler_view = view.findViewById(R.id.upcoming_movies_recycler_view);
        (new LinearSnapHelper()).attachToRecyclerView(upcoming_recycler_view);
        upcomingMoviesList = new ArrayList<>();
        upcomingAdapter = new MovieCustomAdapterTypeThree(getContext(),upcomingMoviesList);

        now_showing_recycler_view.setAdapter(nowShowingAdapter);
        now_showing_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        popular_recycler_view.setAdapter(popularAdapter);
        popular_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        top_rated_recycler_view.setAdapter(topRatedAdapter);
        top_rated_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        upcoming_recycler_view.setAdapter(upcomingAdapter);
        upcoming_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        now_showing_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_MOVIES,Constants.NOW_SHOWING_MOVIES);
                startActivity(intent);

            }
        });

        popular_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_MOVIES,Constants.POPULAR_MOVIES);
                startActivity(intent);

            }
        });

        top_rated_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_MOVIES,Constants.TOP_RATED_MOVIES);
                startActivity(intent);
            }
        });

        upcoming_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_MOVIES,Constants.UPCOMING_MOVIES);
                startActivity(intent);
            }
        });


        loadFragment();

        return view;
    }

    private void loadFragment() {

        if(MovieGenreGiver.isListLoaded()){

            loadPopularMovies();
            loadNowShowingMovies();
            loadTopRatedMovies();
            loadUpcomingMovies();
        }else{

            RetrofitGiver.giveInstance().create(RetrofitCalls.class).getMovieGenresList(Constants.API_KEY).enqueue(new Callback<GenresListResponse>() {
                @Override
                public void onResponse(Call<GenresListResponse> call, Response<GenresListResponse> response) {

                    if(response.body() == null){
                        return;
                    }

                    if(response.body().getGenres() == null){
                        return;
                    }

                    MovieGenreGiver.loadList(response.body().getGenres());
                    loadPopularMovies();
                    loadNowShowingMovies();
                    loadTopRatedMovies();
                    loadUpcomingMovies();

                }

                @Override
                public void onFailure(Call<GenresListResponse> call, Throwable t) {

                }
            });

        }



    }

    private void loadUpcomingMovies() {

        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getUpcomingMovies(Constants.API_KEY,1,"US").enqueue(new Callback<MovieResponseCategorical>() {
            @Override
            public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {

                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                upcomingLoaded = true;
                checkAllDataLoaded();

                for (MovieResponseGeneral movie : response.body().getResults())
                    if(movie != null && movie.getPoster_path() != null)
                        upcomingMoviesList.add(movie);

                upcomingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {

            }
        });

    }

    private void checkAllDataLoaded() {

        if(popularLoaded && nowShowingLoaded && upcomingLoaded && topRatedLoaded){

            indicatorView.hide();
            visibilityLayout.setVisibility(View.VISIBLE);

        }

    }

    private void loadTopRatedMovies() {

        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getTopRatedMovies(Constants.API_KEY,1,"US").enqueue(new Callback<MovieResponseCategorical>() {
            @Override
            public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {
                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                topRatedLoaded = true;
                checkAllDataLoaded();

                for (MovieResponseGeneral movie : response.body().getResults())
                    if(movie != null && movie.getPoster_path() != null)
                        topRatedMoviesList.add(movie);

                topRatedAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {

            }
        });

    }

    private void loadNowShowingMovies() {
        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getNowShowingMovies(Constants.API_KEY,1,"US").enqueue(new Callback<MovieResponseCategorical>() {
            @Override
            public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {
                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                nowShowingLoaded = true;
                checkAllDataLoaded();

                for (MovieResponseGeneral movie : response.body().getResults())
                    if(movie != null && movie.getPoster_path() != null)
                        nowShowingMoviesList.add(movie);

                nowShowingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {

            }
        });

    }

    private void loadPopularMovies() {
        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getPopularMovies(Constants.API_KEY,1,"US").enqueue(new Callback<MovieResponseCategorical>() {
            @Override
            public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {
                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                popularLoaded = true;
                checkAllDataLoaded();

                for (MovieResponseGeneral movie : response.body().getResults())
                    if(movie != null && movie.getBackdrop_path() != null)
                        popularMoviesList.add(movie);

                popularAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {

            }
        });

    }

}
