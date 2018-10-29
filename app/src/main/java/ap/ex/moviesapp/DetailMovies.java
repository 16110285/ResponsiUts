package ap.ex.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class DetailMovies extends AppCompatActivity {
    ImageView Poster;
    TextView Title, Rating, Release;

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movies);
        Poster = (ImageView)findViewById(R.id.poster);
        Title = (TextView)findViewById(R.id.tittle);
        Rating = (TextView)findViewById(R.id.rating);
        Release = (TextView)findViewById(R.id.release);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movies"), Result.class);

        Picasso.with(DetailMovies.this)
                .load("http://image.tmdb.org/t/p/w185/"+result.getPosterPath())
                .into(Poster);
        Title.setText("Movie Title \n"+result.getTitle());
        Release.setText("Release Date : \n"+result.getReleaseDate());
        Rating.setText("Vote Average : "+Double.toString(result.getVoteAverage()));
    }

}
