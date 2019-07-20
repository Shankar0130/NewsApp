package com.shankaryadav.www.newsapp;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {

    RecyclerView recyclerView;

List<String> list = new ArrayList<> ();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



       View v = inflater.inflate (R.layout.fragment_category, container, false);
       recyclerView = v.findViewById (R.id.recyclerCategory);


       list.add ("business");
       list.add ("sports");
       list.add ("entertainment");
       list.add ("business");
       list.add ("politics");
       list.add ("Technology");
       list.add ("health");


        recyclerView.setLayoutManager (new LinearLayoutManager (getActivity ()));


        recyclerView.setHasFixedSize (true);


        recyclerView.setItemAnimator (new DefaultItemAnimator ());


        recyclerView.addItemDecoration (new DividerItemDecoration (getActivity (),DividerItemDecoration.VERTICAL));


        recyclerView.setAdapter (new Category_Adapter (list,getActivity ()));


        return  v;

    }


}