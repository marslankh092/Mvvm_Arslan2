package com.example.mvvm_arslan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

//http://192.168.100.170/api/json_user_fetch.php
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.myviewholder> {
    List<ModelEmployees> movielist;

    public MovieListAdapter(List<ModelEmployees> list) {
        this.movielist = list;
    }

    public void updatemovielist(List<ModelEmployees> list) {
        if (this.movielist!=null) {
            this.movielist.clear();
        }
        this.movielist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.title.setText(movielist.get(position).getName());
        // holder.title.setText(movielist.get(position).getImage());
        Glide.with(holder.title.getContext()).load("http://192.168.100.170/api/images/" + movielist.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        if (this.movielist != null)
            return this.movielist.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rec);
            img = itemView.findViewById(R.id.img_rec);
        }
    }
}