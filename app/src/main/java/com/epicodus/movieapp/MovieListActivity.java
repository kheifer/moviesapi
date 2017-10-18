package com.epicodus.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;


public class MovieListActivity extends AppCompatActivity {
     public static final String TAG = "TEST/MovieListActivity";
     @Bind(R.id.responseTextView) TextView mNewSearchString;
     @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        mNewSearchString.setText("You searched for: "+query);

        getMovies(query);
    }
    private void getMovies(String query){
        final MovieService movieService = new MovieService();
        movieService.findMovies(query, new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
