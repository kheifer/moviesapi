package com.epicodus.movieapp;

/**
 * Created by Guest on 10/18/17.
 */

public class Movie {
    private String mPoster;
    private String mTitle;
    private String mSynopsis;
    private String mRelease;
    private double mRating;

    public Movie(String poster, String title, String synopsis, String release, double rating){
        this.mPoster = poster;
        this.mTitle = title;
        this.mSynopsis = synopsis;
        this.mRelease = release;
        this.mRating = rating;
    }

    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSynopsis() {
        return mSynopsis;
    }

    public void setmSynopsis(String mSynopsis) {
        this.mSynopsis = mSynopsis;
    }

    public String getmRelease() {
        return mRelease;
    }

    public void setmRelease(String mRelease) {
        this.mRelease = mRelease;
    }

    public double getmRating() {
        return mRating;
    }

    public void setmRating(double mRating) {
        this.mRating = mRating;
    }
}
