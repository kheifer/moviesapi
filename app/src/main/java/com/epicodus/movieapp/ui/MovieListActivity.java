package com.epicodus.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.movieapp.adapters.MovieListAdapter;
import com.epicodus.movieapp.services.MovieService;
import com.epicodus.movieapp.R;
import com.epicodus.movieapp.models.Movie;

import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;


public class MovieListActivity extends AppCompatActivity {
    public static final String TAG = "TEST/MovieListActivity";
    @Bind (R.id.recycleViewer) RecyclerView mRecycleView;
    private MovieListAdapter mAdapter;
    public ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");


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
            public void onResponse(Call call, Response response){

                mMovies = movieService.processResults(response);

                MovieListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new MovieListAdapter(getApplicationContext(), mMovies);
                        mRecycleView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MovieListActivity.this);
                        mRecycleView.setLayoutManager(layoutManager);
                        mRecycleView.setHasFixedSize(true);

                    }
                });

            }
        });
    }
}
