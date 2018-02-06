package com.example.welcome.movtails.Network.TVShows;

import com.example.welcome.movtails.Network.Movie.Genre;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by WELCOME on 04-12-2017.
 */

public class TVShowGenreGiver {

    private static HashMap<Integer,String> map;

    public static Boolean isListLoaded(){
        return map != null;
    }

    public static void loadList(ArrayList<GenreTV> genres){
        if(genres == null){
            return;
        }
        map = new HashMap<>();

        for(GenreTV genre : genres){
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
