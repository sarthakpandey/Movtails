package com.example.welcome.movtails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.example.welcome.movtails.Adapters.MovieSeeMoreCustomAdapter;
import com.example.welcome.movtails.Adapters.TVShowSeeMoreCustomAdapter;
import com.example.welcome.movtails.Network.Movie.MovieResponseCategorical;
import com.example.welcome.movtails.Network.Movie.MovieResponseGeneral;
import com.example.welcome.movtails.Network.RetrofitCalls;
import com.example.welcome.movtails.Network.RetrofitGiver;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseCategorical;
import com.example.welcome.movtails.Network.TVShows.TVShowResponseGeneral;
import com.eyalbira.loadingdots.LoadingDots;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;


import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeeMoreActivity extends AppCompatActivity {

    private AVLoadingIndicatorView indicatorView;

    private RecyclerView recyclerView;
    private ArrayList<MovieResponseGeneral> mMovies;
    private ArrayList<TVShowResponseGeneral> mTVShow;
    private TVShowSeeMoreCustomAdapter tvShowSeeMoreCustomAdapter;
    private MovieSeeMoreCustomAdapter movieSeeMoreCustomAdapter;

    private int movie_type;
    private int tv_show_type;

    private boolean pageOver = false;
    private int presentPage = 1;
    private boolean loading = true;
    private int previousTotal = 0;
    private int visibleThreshold = 2;
    HashMap<Integer,Integer> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more);
        indicatorView = (AVLoadingIndicatorView)findViewById(R.id.avi_progress);

        indicatorView.show();

        movie_type = getIntent().getIntExtra(Constants.TYPE_MOVIES,-1);
        tv_show_type = getIntent().getIntExtra(Constants.TYPE_TV_SHOWS,-1);

        if(movie_type == -1 && tv_show_type == -1)
            finish();

        recyclerView = (RecyclerView)findViewById(R.id.see_more_recycler_view);

        recyclerView.setNestedScrollingEnabled(false);

        if(movie_type != -1){

            switch (movie_type){

                case Constants.NOW_SHOWING_MOVIES : setTitle("Now Showing Movies");
                break;

                case Constants.POPULAR_MOVIES:  setTitle("Popular Movies");
                break;

                case Constants.TOP_RATED_MOVIES:  setTitle("Top Rated Movies");
                break;

                case Constants.UPCOMING_MOVIES : setTitle("Upcoming Movies");
                break;

            }

            mMovies = new ArrayList<>();
            movieSeeMoreCustomAdapter = new MovieSeeMoreCustomAdapter(this,mMovies);
            recyclerView.setAdapter(movieSeeMoreCustomAdapter);
             final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);


            recyclerView.setLayoutManager(gridLayoutManager);

            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    String TAG = "tagged";

                    Log.i(TAG, "onScrolled: inside");

                    int visibleItemCount = gridLayoutManager.getChildCount();
                    int totalItemCount = gridLayoutManager.getItemCount();
                    int firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false;
                            previousTotal = totalItemCount;
                        }
                    }
                    if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                        indicatorView.show();
   //                     mElasticDownloadView.setProgress(0);
                        Log.i(TAG, "onScrolled: loading movies");
                        loadMovies(movie_type);
                        loading = true;
                    }
                }
            });

            loadMovies(movie_type);
        }else{

            switch (tv_show_type){

                case Constants.AIRING_TODAY_TV_SHOWS : setTitle("Airing Today TV Shows");
                    break;

                case Constants.POPULAR_TV_SHOWS:  setTitle("Popular TV Shows");
                    break;

                case Constants.TOP_RATED_TV_SHOWS:  setTitle("Top Rated TV Shows");
                    break;

                case Constants.ON_THE_AIR_TV_SHOWS : setTitle("On The Air TV Shows");
                    break;

            }

            mTVShow = new ArrayList<>();
            tvShowSeeMoreCustomAdapter = new TVShowSeeMoreCustomAdapter(this,mTVShow);
            recyclerView.setAdapter(tvShowSeeMoreCustomAdapter);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(gridLayoutManager);

            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    int visibleItemCount = gridLayoutManager.getChildCount();
                    int totalItemCount = gridLayoutManager.getItemCount();
                    int firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false;
                            previousTotal = totalItemCount;
                        }
                    }
                    if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {

                        indicatorView.show();
                        loadTvShows(tv_show_type);
                        loading = true;
                    }


                }
            });



            loadTvShows(tv_show_type);

        }


        AlphaAnimation animation = new AlphaAnimation(0,1);

        animation.setDuration(1690);

//        recyclerView.setAnimation(animation);
//
//        recyclerView.setItemAnimator(new FadeInAnimator());
//
//        recyclerView.getItemAnimator().setAddDuration(3000);
//        recyclerView.getItemAnimator().setChangeDuration(3000);

    }


    private void loadTvShows(int tv_show_type) {
        if(pageOver)
            return;

        //loadingDots.setVisibility(View.VISIBLE);

        indicatorView.show();

     //   mElasticDownloadView.setProgress(0);
        RetrofitCalls call = RetrofitGiver.giveInstance().create(RetrofitCalls.class);

        switch (tv_show_type){

            case Constants.AIRING_TODAY_TV_SHOWS :
                //indicatorView.show();
                 call.getAiringTodayTVShows(Constants.API_KEY,presentPage).enqueue(new Callback<TVShowResponseCategorical>() {
                     @Override
                     public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {
                         if(response.body() == null || response.body().getResults() == null)
                             return;

                         indicatorView.hide();

                        // loading = false;
                         for (TVShowResponseGeneral general : response.body().getResults()){
                             if(general != null && general.getBackdrop_path() != null && general.getName() != null && map.get(general.getId()) == null){
                                 mTVShow.add(general);
                                 map.put(general.getId(),1);
                             }

                         }

                         tvShowSeeMoreCustomAdapter.notifyDataSetChanged();

       //           mElasticDownloadView.success();
                         //indicatorView.hide();


                         if(response.body().getPage() == response.body().getTotal_pages())
                             pageOver = true;

                         else
                             presentPage++;
         //                mElasticDownloadView.success();

                    //     indicatorView.hide();

                     }

                     @Override
                     public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {

                         //loading = false;
                     }
                 });


                 break;

            case Constants.ON_THE_AIR_TV_SHOWS:
                call.getOnTheAirTVShows(Constants.API_KEY,presentPage).enqueue(new Callback<TVShowResponseCategorical>() {
                    @Override
                    public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {
                        if(response.body() == null || response.body().getResults() == null)
                            return;

                        indicatorView.hide();
                        //loading = false;
                        for (TVShowResponseGeneral general : response.body().getResults()){
                            if(general != null && general.getBackdrop_path() != null && general.getName() != null && map.get(general.getId()) == null){
                                mTVShow.add(general);
                                map.put(general.getId(),1);
                            }

                        }
                        tvShowSeeMoreCustomAdapter.notifyDataSetChanged();
                        if(response.body().getPage() == response.body().getTotal_pages())
                            pageOver = true;


                        else
                            presentPage++;
//                        mElasticDownloadView.success();
                        //indicatorView.hide();
                    }

                    @Override
                    public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {
                        //loading = false;
                    }
                });
                break;
        case Constants.TOP_RATED_TV_SHOWS:
            call.getTopRatedTVShows(Constants.API_KEY,presentPage).enqueue(new Callback<TVShowResponseCategorical>() {
                @Override
                public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {
                    if(response.body() == null || response.body().getResults() == null)
                        return;

                    indicatorView.hide();
                    //loading = false;
                    for (TVShowResponseGeneral general : response.body().getResults()){
                        if(general != null && general.getBackdrop_path() != null && general.getName() != null && map.get(general.getId()) == null){
                            mTVShow.add(general);
                            map.put(general.getId(),1);
                        }

                    }
                    tvShowSeeMoreCustomAdapter.notifyDataSetChanged();
                    if(response.body().getPage() == response.body().getTotal_pages())
                        pageOver = true;

                    else
                        presentPage++;

                //    indicatorView.hide();
  //                  mElasticDownloadView.success();
                }

                @Override
                public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {
                    //loading = false;
                }
            });

            break;

            case Constants.POPULAR_TV_SHOWS:
                call.getPopularTVShows(Constants.API_KEY,presentPage).enqueue(new Callback<TVShowResponseCategorical>() {
                    @Override
                    public void onResponse(Call<TVShowResponseCategorical> call, Response<TVShowResponseCategorical> response) {
                        if(response.body() == null || response.body().getResults() == null)
                            return;
                      //  loading = false;
                        indicatorView.hide();

                        for (TVShowResponseGeneral general : response.body().getResults()){
                            if(general != null && general.getBackdrop_path() != null && general.getName() != null && map.get(general.getId()) == null){
                                mTVShow.add(general);
                                map.put(general.getId(),1);
                            }

                        }
                        tvShowSeeMoreCustomAdapter.notifyDataSetChanged();
                        if(response.body().getPage() == response.body().getTotal_pages())
                            pageOver = true;

                        else
                            presentPage++;

                 //       indicatorView.hide();
    //                    mElasticDownloadView.success();
                    }

                    @Override
                    public void onFailure(Call<TVShowResponseCategorical> call, Throwable t) {
                        //loading = false;
                    }
                });
                break;

        }

        indicatorView.hide();

    }

    private void loadMovies(int movie_type) {

        if(pageOver)
            return;

        indicatorView.show();

      //  mElasticDownloadView.setProgress(0);

        RetrofitCalls call = RetrofitGiver.giveInstance().create(RetrofitCalls.class);

        switch (movie_type){

            case Constants.NOW_SHOWING_MOVIES :

                call.getNowShowingMovies(Constants.API_KEY,presentPage,"US").enqueue(new Callback<MovieResponseCategorical>() {
                    @Override
                    public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {

                        if(response.body() == null || response.body().getResults() == null)
                            return;

                        indicatorView.hide();
                        //loading = false;
                        for (MovieResponseGeneral movie : response.body().getResults()){
                            if(movie != null && movie.getTitle() != null && movie.getBackdrop_path() != null && map.get(movie.getId()) == null){
                                mMovies.add(movie);
                                map.put(movie.getId(),1);
                            }
                        }

                        movieSeeMoreCustomAdapter.notifyDataSetChanged();


                        if(response.body().getPage() == response.body().getTotal_pages())
                            pageOver = true;

                        else
                            presentPage++;

                     //   indicatorView.hide();
//                        mElasticDownloadView.success();
                    }

                    @Override
                    public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {
                        //loading = false;
                    }
                });

                break;

            case Constants.POPULAR_MOVIES:

                call.getPopularMovies(Constants.API_KEY,presentPage,"US").enqueue(new Callback<MovieResponseCategorical>() {
                    @Override
                    public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {
                        if(response.body() == null || response.body().getResults() == null)
                            return;

                      indicatorView.hide();
                        //loading = false;
                        for (MovieResponseGeneral movie : response.body().getResults()){
                            if(movie != null && movie.getTitle() != null && movie.getBackdrop_path() != null && map.get(movie.getId()) == null){
                                mMovies.add(movie);
                                map.put(movie.getId(),1);
                            }
                        }

                        movieSeeMoreCustomAdapter.notifyDataSetChanged();


                        if(response.body().getPage() == response.body().getTotal_pages())
                            pageOver = true;

                        else
                            presentPage++;

                     //   indicatorView.hide();
  //                      mElasticDownloadView.success();
                    }

                    @Override
                    public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {
                        //loading = false;
                    }
                });

                break;

            case Constants.UPCOMING_MOVIES :

                call.getUpcomingMovies(Constants.API_KEY,presentPage,"US").enqueue(new Callback<MovieResponseCategorical>() {
                    @Override
                    public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {
                        if(response.body() == null || response.body().getResults() == null)
                            return;

                        indicatorView.hide();
                        //loading = false;
                        for (MovieResponseGeneral movie : response.body().getResults()){
                            if(movie != null && movie.getTitle() != null && movie.getBackdrop_path() != null && map.get(movie.getId()) == null){
                                mMovies.add(movie);
                                map.put(movie.getId(),1);
                            }
                        }

                        movieSeeMoreCustomAdapter.notifyDataSetChanged();


                        if(response.body().getPage() == response.body().getTotal_pages())
                            pageOver = true;

                        else
                            presentPage++;

                  //      indicatorView.hide();
    //                    mElasticDownloadView.success();
                    }

                    @Override
                    public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {
                        //loading = false;
                    }
                });

                break;

            case Constants.TOP_RATED_MOVIES:

                call.getTopRatedMovies(Constants.API_KEY,presentPage,"US").enqueue(new Callback<MovieResponseCategorical>() {
                    @Override
                    public void onResponse(Call<MovieResponseCategorical> call, Response<MovieResponseCategorical> response) {
                        if(response.body() == null || response.body().getResults() == null)
                            return;
                        indicatorView.hide();
                    //    indicatorView.hide();
                        //loading = false;
                        for (MovieResponseGeneral movie : response.body().getResults()){
                            if(movie != null && movie.getTitle() != null && movie.getBackdrop_path() != null && map.get(movie.getId()) == null){
                                mMovies.add(movie);
                                map.put(movie.getId(),1);
                            }
                        }

                        movieSeeMoreCustomAdapter.notifyDataSetChanged();


                        if(response.body().getPage() == response.body().getTotal_pages())
                            pageOver = true;

                        else
                            presentPage++;

                 //       indicatorView.hide();

      //                  mElasticDownloadView.success();

                    }

                    @Override
                    public void onFailure(Call<MovieResponseCategorical> call, Throwable t) {
                        //loading = false;
                    }
                });

                break;
        }



    }


}
