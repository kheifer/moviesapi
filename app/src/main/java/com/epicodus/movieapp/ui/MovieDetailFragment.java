package com.epicodus.movieapp.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.movieapp.R;
import com.epicodus.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MovieDetailFragment extends Fragment implements View.OnClickListener{
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.movieTitle) TextView mMovieTitle;
    @Bind(R.id.synopsis) TextView mSynopsis;
    @Bind(R.id.movieImage) ImageView mImage;
    @Bind(R.id.ratingTextView) TextView mRating;
    @Bind(R.id.releaseDate) TextView mRelease;
    @Bind(R.id.websiteTextView) TextView mWebsite;

    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));

        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getmPoster()).resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop().into(mImage);

        mMovieTitle.setText(mMovie.getmTitle());
        mSynopsis.setText(mMovie.getmSynopsis());
        mRating.setText(Double.toString(mMovie.getmRating()) + "/10");
        mRelease.setText(mMovie.getmRelease());

        mWebsite.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == mWebsite){
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=" + mMovie.getmTitle()));
            startActivity(webIntent);
        }
    }
}
