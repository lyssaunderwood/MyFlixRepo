package com.example.lyssaunderwood.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    //public String title;
   //public String posterUrl;
    //public int rating;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }

    public double getRating() {
        return rating;
    }

    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;
    double rating;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.rating = jsonObject.getDouble("vote_average");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }



//
//    public Movie(String title, String posterUrl, int rating) {
//        this.title = title;
//        this.posterUrl = posterUrl;
//        this.rating = rating;
//    }
//
//    public static ArrayList<Movie> getFakeMovies() {
//        ArrayList<Movie> movies = new ArrayList<>();
//
//        for(int i = 0; i < 60; i++) {
//        movies.add(new Movie("The Social Network", "", 75));
//        movies.add(new Movie("The Internship", "", 50));
//        movies.add(new Movie("The Lion King", "", 100));
//        }
//
//        return movies;
//    }
//
//
//    @Override
//    public String toString() {
//        return title + "-" + rating;
//    }
}
