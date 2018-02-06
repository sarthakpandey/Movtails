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

import com.example.welcome.movtails.Adapters.TVShowCustomAdapterTypeOne;
import com.example.welcome.movtails.Adapters.TVShowCustomAdapterTypeThree;
import com.example.welcome.movtails.Adapters.TVShowCustomAdapterTypeTwo;
import com.example.welcome.movtails.Constants;
import com.example.welcome.movtails.Network.RetrofitCalls;
import com.example.welcome.movtails.Network.RetrofitGiver;
import com.example.welcome.movtails.Network.TVShows.GenresListResponseTV;
import com.example.welcome.movtails.Network.TVShows.TVShowGenreGiver;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseCategorical;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseGeneral;
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
public class TVShowsFragment extends Fragment {


    private AVLoadingIndicatorView indicatorView;
    private LinearLayout visibilityLayout;

    private Boolean airingTodayLoaded;
    private Boolean popularLoaded;
    private Boolean topRatedLoaded;
    private Boolean onTheAirLoaded;

    private CardView popular_see_more;
    private RecyclerView popular_recycler_view;
    private ArrayList<TVShowResponseGeneral> popularList;
    private TVShowCustomAdapterTypeTwo popularAdapter;

    private CardView airing_today_see_more;
    private RecyclerView airing_today_recycler_view;
    private ArrayList<TVShowResponseGeneral> airingTodayList;
    private TVShowCustomAdapterTypeOne airingTodayAdapter;

    private CardView top_rated_see_more;
    private RecyclerView top_rated_recycler_view;
    private ArrayList<TVShowResponseGeneral> topRatedList;
    private TVShowCustomAdapterTypeOne topRatedAdapter;

    private CardView on_the_air_see_more;
    private RecyclerView on_the_air_recycler_view;
    private ArrayList<TVShowResponseGeneral> onTheAirList;
    private TVShowCustomAdapterTypeThree onTheAirAdapter;


    public TVShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);


        popularLoaded = false;
        airingTodayLoaded = false;
        topRatedLoaded = false;
        onTheAirLoaded = false;

        indicatorView = view.findViewById(R.id.avi_progress);
        visibilityLayout = view.findViewById(R.id.visibility_layout);

        visibilityLayout.setVisibility(View.GONE);
        indicatorView.show();

        popular_see_more = view.findViewById(R.id.popular_tv_shows_see_more);
        popular_recycler_view = view.findViewById(R.id.popular_tv_shows_recycler_view);
        (new LinearSnapHelper()).attachToRecyclerView(popular_recycler_view);
        popularList = new ArrayList<>();
        popularAdapter = new TVShowCustomAdapterTypeTwo(getContext(),popularList);


        airing_today_see_more = view.findViewById(R.id.airing_today_tv_shows_see_more);
        airing_today_recycler_view = view.findViewById(R.id.airing_today_tv_shows_recycler_view);
        airingTodayList = new ArrayList<>();
        airingTodayAdapter = new TVShowCustomAdapterTypeOne(getContext(),airingTodayList);



        top_rated_see_more = view.findViewById(R.id.top_rated_tv_shows_see_more);
        top_rated_recycler_view = view.findViewById(R.id.top_rated_tv_shows_recycler_view);
        topRatedList = new ArrayList<>();
        topRatedAdapter = new TVShowCustomAdapterTypeOne(getContext(),topRatedList);



        on_the_air_see_more = view.findViewById(R.id.on_the_air_tv_shows_see_more);
        on_the_air_recycler_view = view.findViewById(R.id.on_the_air_tv_shows_recycler_view);
        (new LinearSnapHelper()).attachToRecyclerView(on_the_air_recycler_view);
        onTheAirList = new ArrayList<>();
        onTheAirAdapter = new TVShowCustomAdapterTypeThree(getContext(),onTheAirList);

        airing_today_recycler_view.setAdapter(airingTodayAdapter);
        airing_today_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        popular_recycler_view.setAdapter(popularAdapter);
        popular_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        top_rated_recycler_view.setAdapter(topRatedAdapter);
        top_rated_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        on_the_air_recycler_view.setAdapter(onTheAirAdapter);
        on_the_air_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        airing_today_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_TV_SHOWS,Constants.AIRING_TODAY_TV_SHOWS);
                startActivity(intent);

            }
        });

        popular_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_TV_SHOWS,Constants.POPULAR_TV_SHOWS);
                startActivity(intent);

            }
        });

        top_rated_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_TV_SHOWS,Constants.TOP_RATED_TV_SHOWS);
                startActivity(intent);
            }
        });

        on_the_air_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeMoreActivity.class);
                intent.putExtra(Constants.TYPE_TV_SHOWS,Constants.ON_THE_AIR_TV_SHOWS);
                startActivity(intent);
            }
        });

        loadFragment();

        return view;
    }

    private void loadFragment() {

        if(TVShowGenreGiver.isListLoaded()){

            loadAiringToday();
            loadPopular();
            loadTopRated();
            loadOnTheAir();

        }else{

            RetrofitGiver.giveInstance().create(RetrofitCalls.class).getTVShowGenresList(Constants.API_KEY).enqueue(new Callback<GenresListResponseTV>() {
                @Override
                public void onResponse(Call<GenresListResponseTV> call, Response<GenresListResponseTV> response) {

                    if(response.body() == null)
                        return;

                    if(response.body().getGenres() == null)
                        return;

                    TVShowGenreGiver.loadList(response.body().getGenres());
                    loadAiringToday();
                    loadPopular();
                    loadTopRated();
                    loadOnTheAir();

                }

                @Override
                public void onFailure(Call<GenresListResponseTV> call, Throwable t) {

                }
            });

        }



    }

    private void loadOnTheAir() {
        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getOnTheAirTVShows(Constants.API_KEY,1).enqueue(new Callback<TVShowResponseCategorical>() {
            @Override
            public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {

                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                onTheAirLoaded = true;

                checkAllDataLoaded();

                for(TVShowResponseGeneral tvshow : response.body().getResults()){

                    if(tvshow != null && tvshow.getPoster_path() != null){
                        onTheAirList.add(tvshow);
                    }



                }

                onTheAirAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {

            }
        });
    }

    private void checkAllDataLoaded() {
        if(onTheAirLoaded && airingTodayLoaded && popularLoaded && topRatedLoaded){
            indicatorView.hide();
            visibilityLayout.setVisibility(View.VISIBLE);
        }
    }

    private void loadTopRated() {
        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getTopRatedTVShows(Constants.API_KEY,1).enqueue(new Callback<TVShowResponseCategorical>() {
            @Override
            public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {

                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                topRatedLoaded = true;

                checkAllDataLoaded();

                for(TVShowResponseGeneral tvshow : response.body().getResults()) {

                    if (tvshow != null && tvshow.getPoster_path() != null) {
                        topRatedList.add(tvshow);
                    }
                }
                    topRatedAdapter.notifyDataSetChanged();

                }

            @Override
            public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {

            }
        });

    }

    private void loadPopular() {
        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getPopularTVShows(Constants.API_KEY,1).enqueue(new Callback<TVShowResponseCategorical>() {
            @Override
            public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {
                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                popularLoaded = true;

                checkAllDataLoaded();

                for(TVShowResponseGeneral tvshow : response.body().getResults()) {

                    if (tvshow != null && tvshow.getBackdrop_path() != null) {
                        popularList.add(tvshow);
                    }
                }
                popularAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {

            }
        });

    }

    private void loadAiringToday() {
        indicatorView.show();

        RetrofitGiver.giveInstance().create(RetrofitCalls.class).getAiringTodayTVShows(Constants.API_KEY,1).enqueue(new Callback<TVShowResponseCategorical>() {
            @Override
            public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {
                if(response.body() == null)
                    return;

                if(response.body().getResults() == null)
                    return;

                airingTodayLoaded = true;

                checkAllDataLoaded();

                for(TVShowResponseGeneral tvshow : response.body().getResults()) {

                    if (tvshow != null && tvshow.getPoster_path() != null) {
                        airingTodayList.add(tvshow);
                    }
                }
                airingTodayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {

            }
        });

    }

}
