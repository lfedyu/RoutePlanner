package com.fedyushko.lilia.p0031_firstprogect;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlaceViewHolder>  {

    static List<Place> places;
    public static class PlaceViewHolder extends RecyclerView.ViewHolder  {


        CardView cv;
        TextView placeName;
        TextView placeInfo;
        ImageView placePhoto;
            ImageView placeAdd;
            public View view;
            public static Place currentItem;//????

        PlaceViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            placeName = (TextView)itemView.findViewById(R.id.place_name);
            placeInfo = (TextView)itemView.findViewById(R.id.place_info);
            placePhoto = (ImageView)itemView.findViewById(R.id.place_photo);
            placeAdd = (ImageView)itemView.findViewById(R.id.place_add);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    Intent intent = new Intent(v.getContext(),Place_Activity.class );

                    intent.putExtra("photoId",places.get(adapterPosition).getPhotoId());
                    intent.putExtra("placeName", places.get(adapterPosition).getName());
                    intent.putExtra("longInfo", places.get(adapterPosition).getLongInfo());
                    v.getContext().startActivity(intent);
                    }
            });

        }


    }



    RVAdapter(List<Place> places){
        this.places = places;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PlaceViewHolder pvh = new PlaceViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder placeViewHolder, int i) {
        placeViewHolder.placeName.setText(places.get(i).name);
        placeViewHolder.placeInfo.setText(places.get(i).info);
        placeViewHolder.placePhoto.setImageResource(places.get(i).photoId);
        placeViewHolder.placeAdd.setImageResource(places.get(i).addId);
       // placeViewHolder.bind(places.get(i), listener);

//        placeViewHolder.setItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Toast.makeText(mContext,places.get(position).getName(),Toast.LENGTH_SHORT).show();
//                Intent i=new Intent(mContext, Toast.class);
//                mContext.startActivity(i);
//            }
//        });
        //PlaceViewHolder.currentItem = places.get(i);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
