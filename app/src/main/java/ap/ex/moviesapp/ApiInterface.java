package ap.ex.moviesapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiInterface {

    public static String DP_API = "9d6270e7e0b216303094cbddfe8ba2a0";

    @GET("top_rated?api_key="+DP_API)
    Call<Movies> getTopRated();
}
