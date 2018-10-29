package ap.ex.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Main extends AppCompatActivity {

    RecyclerView mView;
    MovieAdapter adapter;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mView = (RecyclerView)findViewById(R.id.movieView);
        mView.setLayoutManager(new GridLayoutManager(Main.this,2));

        movieLoad();
    }

    private void movieLoad(){
        ApiInterface api = ApiClient.getRetrofit().create(ApiInterface.class);
        retrofit2.Call<Movies> call = api.getTopRated();
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(retrofit2.Call<Movies> call, Response<Movies> response) {
                Movies movies = response.body();
                adapter = new MovieAdapter(results);
                adapter.setData(movies.getResults());
                mView.setAdapter(adapter);
            }

            @Override
            public void onFailure(retrofit2.Call<Movies> call, Throwable t) {

            }
        });
    }
}
