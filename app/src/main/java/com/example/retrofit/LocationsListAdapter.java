package com.example.retrofit;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocationsListAdapter  extends RecyclerView.Adapter<LocationsListAdapter.LocationListViewHolder> {
    public List<Locations> locationList = new ArrayList<>();

    @NonNull
    @Override
    public LocationsListAdapter.LocationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_locations, parent, false);
        return new LocationListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationsListAdapter.LocationListViewHolder holder, int position) {
        Locations locations = locationList.get(position);

        holder.nom.setText("Nombre del lugar: "+locations.name);
        holder.terrain.setText("Terreno: "+ locations.terrain);

        holder.vacio.setText(" ");



        //Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" + movie.poster_path).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    class LocationListViewHolder extends RecyclerView.ViewHolder {
        TextView nom;
        TextView terrain;
        TextView vacio;
        public LocationListViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.locationName);
            terrain = itemView.findViewById(R.id.locationTerrain);

            vacio= itemView.findViewById(R.id.vacio);

        }
    }
}
