package com.shankaryadav.www.newsapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.CategoryViewHolder> {


    List<String> list;
    Activity activity;

    public Category_Adapter(List<String> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from (viewGroup.getContext ());
        View v = inflater.inflate (R.layout.item_category,viewGroup,false);


        return new CategoryViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {


        categoryViewHolder.textView.setText (list.get (i));
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{


        TextView textView;

        public CategoryViewHolder(@NonNull View itemView) {
            super (itemView);

            textView = itemView.findViewById (R.id.category);

            itemView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    int pos = getAdapterPosition ();

                    Intent intent = new Intent (activity.getBaseContext (),NewsActivity.class);

                    intent.putExtra ("cate",list.get (pos));

                    activity.startActivity (intent);
                }
            });

        }



    }
}
