package com.example.retrofit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class LocationsActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private LocationsListAdapter mLocationListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);



        mRecyclerView = findViewById(R.id.locationList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLocationListAdapter = new LocationsListAdapter();
        mRecyclerView.setAdapter(mLocationListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getLocations().observe(this, new Observer<List<Locations>>() {
            @Override
            public void onChanged(@Nullable List<Locations> locations) {
                mLocationListAdapter.locationList = locations;
                mLocationListAdapter.notifyDataSetChanged();



            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationsActivity.this, FilmsActivity.class);

                startActivity(intent);
            }
        });

    }
}
