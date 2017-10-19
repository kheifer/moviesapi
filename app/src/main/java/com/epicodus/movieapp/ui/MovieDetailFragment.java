package com.epicodus.movieapp.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcel;
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


public class MovieDetailFragment extends Fragment {
    @Bind(R.id.movieTitle)
    TextView mMovieTitle;
    @Bind(R.id.synopsis)
    TextView mSynopsis;
    @Bind(R.id.movieImage)
    ImageView mImage;
    @Bind(R.id.ratingTextView)
    TextView mRating;
    @Bind(R.id.releaseDate)
    TextView mRelease;

    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getmPoster()).into(mImage);

        mMovieTitle.setText(mMovie.getmTitle());
        mSynopsis.setText(mMovie.getmSynopsis());
        mRating.setText(Double.toString(mMovie.getmRating()) + "/10");
        mRelease.setText(mMovie.getmRelease());

        return view;
    }
}
