package com.shankaryadav.www.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class News_fragment extends Fragment {

    List<Posts> list = new ArrayList<> ();
    List<Article> articleList  = new ArrayList<> () ;

    String strcategory = "sports";

   RequestQueue requestQueue;

   String URL_DATA ;

    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate (R.layout.lower_item_fragment,container,false);

        NewsActivity newsActivity = new NewsActivity ();

        strcategory = newsActivity.getCategory ();

        URL_DATA = "https://newsapi.org/v2/top-headlines?country=in&category="+strcategory+"&apiKey=99b8f58c2543478ca88d880b2e0ba900";

       // Toast.makeText (getActivity (), ""+strcategory, Toast.LENGTH_SHORT).show ();

         recyclerView = v.findViewById (R.id.recyclerview);



        recyclerView.setLayoutManager (new LinearLayoutManager (getActivity ()));


        recyclerView.setHasFixedSize (true);


        recyclerView.setItemAnimator (new DefaultItemAnimator ());


        recyclerView.addItemDecoration (new DividerItemDecoration (getActivity (),DividerItemDecoration.VERTICAL));


        loadurl ();



        return v;
    }


    public void loadurl(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, URL_DATA,
                null, new Response.Listener<JSONObject> () {
            @Override
            public void onResponse(JSONObject response) {
                getValue (response);
            }
        },
                new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        requestQueue = Volley.newRequestQueue (getActivity ());

        requestQueue.add (jsonObjectRequest);

    }

    public void getValue(JSONObject response){



            try{
//               JSONObject jsonObject = response.getJSONObject ();

             //   Log.i ("TAG----","---------------------------------\n-------"+jsonObject);


                JSONArray jsonArray = response.getJSONArray ("articles");



                Log.i ("TAG----","---------------------------------\n-------"+jsonArray);

                for (int j=0;j<=jsonArray.length ();j++){

                    Posts posts = new Posts ();

                    Article article = new Article ();


                    article.setTitle ((jsonArray.getJSONObject (j)).getString ("title"));
                    article.setDescription ((jsonArray.getJSONObject (j)).getString ("description"));
                    article.setUrlToImage ((jsonArray.getJSONObject (j)).getString ("urlToImage"));
                    article.setContent ((jsonArray.getJSONObject (j)).getString ("content"));
                    article.setPublishedAt ((jsonArray.getJSONObject (j)).getString ("publishedAt"));


                    articleList.add (article);
                    posts.setArticles (articleList);
                    list.add (posts);


                }

//                posts.getArticles. ((jsonObject.getJSONObject ("title")).getString ("rendered"));
//                posts.setDescription ((jsonObject.getJSONObject ("excerpt")).getString ("rendered"));
//                posts.setPostImg (jsonObject.getString ("jetpack_featured_media_url"));


//                articleList.add (article.setTitle ());
//
//                posts.setArticles ();


                Log.i ("TAG----","---------------------------------\n-------"+jsonArray);


            }catch (JSONException e){
                e.printStackTrace ();
            }


            recyclerView.setAdapter (new NewsAdapter (list,getActivity ()));


    }
}
