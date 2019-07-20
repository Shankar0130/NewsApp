package com.shankaryadav.www.newsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<Posts> list;
    Context context;

    public NewsAdapter(List<Posts> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from (viewGroup.getContext ());

        View view = inflater.inflate (R.layout.item,viewGroup,false);

        return new NewsViewHolder (view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {

        Picasso.get ().load (list.get(i).getArticles ().get (i).getUrlToImage ()).into (newsViewHolder.imageView);
        newsViewHolder.title.setText (list.get (i).getArticles ().get (i).getTitle ());
        newsViewHolder.desc.setText (list.get (i).getArticles ().get (i).getDescription ());

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView desc;
        TextView title;

        public NewsViewHolder(@NonNull final View itemView) {
            super (itemView);

            imageView = itemView.findViewById (R.id.imageview);
            desc = itemView.findViewById (R.id.des);
            title = itemView.findViewById (R.id.title);


            itemView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {


                    int pos = getAdapterPosition ();

                    if (pos != RecyclerView.NO_POSITION){

                        Bundle bundle = new Bundle ();




                        bundle.putString ("title",list.get (pos).getArticles ().get (pos).getTitle ());
                        bundle.putString ("desc",list.get (pos).getArticles ().get (pos).getDescription ());
                        bundle.putString ("image_url",list.get (pos).getArticles ().get (pos).getUrlToImage ());
                        bundle.putString ("date",list.get (pos).getArticles ().get (pos).getPublishedAt ());
                        bundle.putString ("cont",list.get (pos).getArticles ().get (pos).getContent ());


                        Intent intent = new Intent (context.getApplicationContext (), Detail_Activity.class);

                        intent.putExtras (bundle);

                        context.startActivity (intent);

                    }



                }
            });
        }
    }
}
