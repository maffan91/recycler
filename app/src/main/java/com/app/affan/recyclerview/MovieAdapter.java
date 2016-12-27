package com.app.affan.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by affan on 12/25/16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movies;
    private Context context;

    public MovieAdapter(Context context,List<Movie> movies){

        this.context = context;
        this.movies = movies;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(movies.get(position).getTitle());
        holder.genre.setText(movies.get(position).getGenre());
        holder.year.setText(movies.get(position).getYear());
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView year;
        public TextView genre;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            year = (TextView) itemView.findViewById(R.id.year);
            genre = (TextView) itemView.findViewById(R.id.genre);
        }
    }
}
