package ap.ex.moviesapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesHolder> {

    List<Result> results;

    public MovieAdapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_movies, parent, false);
        return new MoviesHolder(view);
    }


    @Override
    public void onBindViewHolder(final MoviesHolder holder, final int position) {
        Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/"+results.get(position).getPosterPath())
                .into(holder.Poster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result data = results.get(position);
                Intent i = new Intent(holder.itemView.getContext(), DetailMovies.class);
                i.putExtra("movies", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivities(new Intent[]{i});
            }
        });
    }

    public void setData(List<Result> results){
        this.results = results;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MoviesHolder extends RecyclerView.ViewHolder{
        ImageView Poster;
           public MoviesHolder(View itemView) {
               super(itemView);
               Poster = (ImageView)itemView.findViewById(R.id.poster);
           }
       }
}
