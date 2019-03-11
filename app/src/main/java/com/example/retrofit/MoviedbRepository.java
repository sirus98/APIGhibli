package com.example.retrofit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviedbRepository {
    MoviedbAPI moviedbAPI;

    public MoviedbRepository(){
        moviedbAPI = MoviedbModule.getAPI();
    }

    public LiveData<List<Movie>> getMovies(){
        final MutableLiveData<List<Movie>> lista = new MutableLiveData<>();

        moviedbAPI.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                lista.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
            }
        });

        return lista;
    }
}