package com.example.retrofit;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private GhibliRepository ghibliRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        ghibliRepository = new GhibliRepository();
    }

    public LiveData<List<Movie>> getMovies(){
        return ghibliRepository.getMovies();
    }

    public LiveData<List<Locations>> getLocations(){
        return ghibliRepository.getLocations();
    }
}