package com.epicodus.movieapp;


import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 10/18/17.
 */

public class MovieService {
    public static void findMovies(String search, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_QUERY_PARAMETER, search);
        urlBuilder.addQueryParameter(Constants.API_KEY_PARAMETER, Constants.API_KEY);

        String url = urlBuilder.build().toString();

        Log.d("URL", url);

        Request request = new Request.Builder()
                        .url(url)
                        .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
