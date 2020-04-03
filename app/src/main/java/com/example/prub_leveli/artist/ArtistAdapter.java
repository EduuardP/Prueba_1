package com.example.prub_leveli.artist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prub_leveli.Models.DataArtist;
import com.example.prub_leveli.Models.TopData;
import com.example.prub_leveli.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<DataArtist> {


    private Context mContext;
    private int mLayoutResourceId;
    private List<DataArtist> artist;

    public ArtistAdapter(@NonNull Context context, int resource, @NonNull List<DataArtist> artist) {
        super(context, resource, artist);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.artist = artist;
    }


    @Nullable
    @Override
    public DataArtist getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        PlaceHolder holder = null;

        if (row==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new PlaceHolder();

            holder.nameArtist = (TextView) row.findViewById(R.id.nameArtist);
            holder.numOyentes = (TextView) row.findViewById(R.id.numOyentesArtist);
            holder.urlArtist = (TextView) row.findViewById(R.id.urlArtist);
          //  holder.zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageArtist);

            row.setTag(holder);
        }
        else
        {
            holder = (PlaceHolder) row.getTag();
        }

      //  Place place = artist[position];

     //   holder.imageView.setOnClickListener(PopupListener);


     //   Integer rowPostion = position;
      //  holder.imageView.setTag(rowPostion);

        holder.nameArtist.setText(artist.get(position).getName());
        holder.numOyentes.setText(artist.get(position).getListeners());
        holder.urlArtist.setText(artist.get(position).getUrl());
       // holder.zipView.setText(String.valueOf(place.mZipCode));
        Picasso.with(getContext())
                .load(artist.get(position).getImage().get(2).getUrl())
                .into(holder.imageView);

        /*
        TextView nameView = row.findViewById(R.id.nameTextView);
        TextView zipView =  row.findViewById(R.id.zipcodeTextView);
        ImageView imageView = row.findViewById(R.id.imageView);
        nameView.setText(place.mNameOfPlace);
        zipView.setText(String.valueOf(place.mZipCode));
        */

       // int resId = mContext.getResources().getIdentifier(place.mNameOfImage,"drawable",mContext.getPackageName());
       // holder.imageView.setImageResource(resId);


        return row;
    }



    private class PlaceHolder {
        TextView nameArtist;
        TextView numOyentes;
        TextView urlArtist;
        ImageView imageView;
    }
}
