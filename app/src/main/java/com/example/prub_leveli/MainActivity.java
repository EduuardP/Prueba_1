package com.example.prub_leveli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prub_leveli.Models.DataArtist;
import com.example.prub_leveli.Models.TopData;
import com.example.prub_leveli.Services.ServiceArtists;
import com.example.prub_leveli.artist.ArtistAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;



public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity" ;
    ListView listArtist;
    ArtistAdapter artistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listArtist = (ListView) findViewById(R.id.listArtist);

        AsyncTask<Void, Void, TopData> data = new ServiceArtists().execute();
        List<DataArtist> datos = null;
        try {
            datos = data.get().getTopartists().getArtist();
            Log.d(TAG, "onCreate: "+datos);

        } catch (ExecutionException e) {
            //e.printStackTrace();

        } catch (InterruptedException e) {
            //e.printStackTrace();
            Log.d(TAG, "onCreate: Error al cargar los datos");

        }



    }





}
