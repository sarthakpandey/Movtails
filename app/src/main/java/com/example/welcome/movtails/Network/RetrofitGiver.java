package com.example.welcome.movtails.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WELCOME on 03-12-2017.
 */

public class RetrofitGiver {

    private static Retrofit retrofit = null;

    public static Retrofit giveInstance(){

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;

    }

}
