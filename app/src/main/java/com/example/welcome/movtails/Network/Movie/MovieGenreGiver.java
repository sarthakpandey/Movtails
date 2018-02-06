package com.example.welcome.movtails.Network.Movie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class MovieGenreGiver {

    private static HashMap<Integer,String> map;

    public static Boolean isListLoaded(){
        return map != null;
    }

    public static void loadList(ArrayList<Genre> genres){
        if(genres == null){
            return;
        }


        map = new HashMap<>();

        for(Genre genre : genres){
            map.put(genre.getId(),genre.getName());
        }

    }

    public static String giveGenre(Integer id){

        if(id == null){
            return null;
        }

        return map.get(id);

    }

}
