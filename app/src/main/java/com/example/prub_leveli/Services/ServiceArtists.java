package com.example.prub_leveli.Services;

import android.os.AsyncTask;

import com.example.prub_leveli.Models.TopData;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceArtists extends AsyncTask<Void, Void, TopData> {

    String url = "https://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=colombia&api_key=829751643419a7128b7ada50de590067&limit=20&format=json";
    private TopData dataArray = null ;
    @Override
    protected TopData doInBackground(Void... voids) {
        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            final String myResponse = response.body().string();

            Gson gson = new Gson();
             dataArray = gson.fromJson(myResponse, TopData.class);



        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return dataArray;
    }

    @Override
    protected void onPostExecute(TopData topData) {
        super.onPostExecute(topData);
    }
}
