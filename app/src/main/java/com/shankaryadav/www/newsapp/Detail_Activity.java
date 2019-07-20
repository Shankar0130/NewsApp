package com.shankaryadav.www.newsapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Detail_Activity extends AppCompatActivity {

ImageView imageView;
TextView title;
TextView desc;
TextView date;
TextView cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detail_);



        imageView = findViewById (R.id.imagecenter);
        title = findViewById (R.id.title);
        desc = findViewById (R.id.description);
        date = findViewById (R.id.date);
        cont = findViewById (R.id.content_desc);





        Bundle bundle = getIntent ().getExtras ();

        String titlestr = bundle.getString ("title");
        String description = bundle.getString ("desc");
        String imgurl = bundle.getString ("image_url");
        String dateStr = bundle.getString ("date");
        String contentstr = bundle.getString ("cont");


        title.setText (titlestr);


        desc.setText (description);


        date.setText (dateStr);


        cont.setText (contentstr);


        Picasso.get ().load (imgurl).into (imageView);




    }
}
