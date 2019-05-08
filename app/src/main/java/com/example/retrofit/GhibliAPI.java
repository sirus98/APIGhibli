package com.example.retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliAPI {
    @GET("/films")
    Call<List<Movie>> getMovies();

    @GET("/locations")
    Call<List<Locations>> getLocations();
}