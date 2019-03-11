package com.example.retrofit;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private MoviedbRepository moviedbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        moviedbRepository = new MoviedbRepository();
    }

    public LiveData<List<Movie>> getMovies(){
        return moviedbRepository.getMovies();
    }
}