package com.bugra.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<Card> mcardlist;
    public static class CardViewHolder extends RecyclerView.ViewHolder {
    //    public ImageView imageView;
        public TextView Desc, CityName, Temp;

        public CardViewHolder(View itemView) {
            super( itemView );
           // imageView = itemView.findViewById( R.id.imageView );
            Desc = itemView.findViewById( R.id.durum );
            CityName = itemView.findViewById( R.id.sehiradi );
            Temp = itemView.findViewById( R.id.tempre );

        }
    }
    public CardAdapter(ArrayList<Card> xcardlist){
        mcardlist = xcardlist;

    }


    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.activity_card, parent, false );
        CardViewHolder cvh = new CardViewHolder( v );
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card currentItem = mcardlist.get(position);
      //  holder.imageView.setImageResource(currentItem.getmImageResource());
        holder.Desc.setText( currentItem.getMdesc() );
        holder.CityName.setText( currentItem.getMcity() );
        holder.Temp.setText( currentItem.getMtemp() );
    }

    @Override
    public int getItemCount() {
        return mcardlist.size();
    }


}