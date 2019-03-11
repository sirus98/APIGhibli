package com.example.retrofit;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>{
    public List<Movie> movieList = new ArrayList<>();

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        holder.title.setText("Titulo: "+movie.title);
        holder.director.setText("Director: "+ movie.director);
        holder.release.setText("Fecha: "+movie.release_date);
        holder.producer.setText("Productor: "+movie.producer);
        holder.rt_score.setText("Nota: "+movie.rt_score);

        holder.vacio.setText(" ");



        //Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" + movie.poster_path).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView director;
        TextView release;
        TextView producer;
        TextView rt_score;
        TextView vacio;
        public MovieListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieTitle);
            director = itemView.findViewById(R.id.movieDirector);
            release = itemView.findViewById(R.id.movieRelease);
            producer = itemView.findViewById(R.id.producer);
            rt_score = itemView.findViewById(R.id.score);
            vacio= itemView.findViewById(R.id.vacio);

        }
    }
}