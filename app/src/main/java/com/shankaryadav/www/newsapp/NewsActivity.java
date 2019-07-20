package com.shankaryadav.www.newsapp;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    String category = "sports";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener () {

        Fragment fragment = null;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId ()) {
                case R.id.navigation_home:
                fragment  = new News_fragment ();
                    break;
                case R.id.navigation_dashboard:
                    fragment = new CategoryFragment ();
                    break;
                case R.id.navigation_notifications:

                    break;
            }

            return loadfragment (fragment);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_news);
        BottomNavigationView navView = findViewById (R.id.nav_view);

        navView.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener);


        getSupportFragmentManager ().beginTransaction ().replace (R.id.lower_fragment,new News_fragment ()).commit ();

        category = getIntent ().getStringExtra ("cate");

        Toast.makeText (this, ""+category, Toast.LENGTH_SHORT).show ();

//try{
//
//
//     category = getIntent ().getStringExtra ("cate");
////
////    if (category != null){
////
//////        Bundle bundle = new Bundle ();
//////        bundle.putString ("categ",category);
//////        News_fragment news_fragment = new News_fragment ();
//////        news_fragment.setArguments (bundle);
//
//    }
//}catch (NullPointerException e){
//    e.printStackTrace ();
//}




    }

    public boolean loadfragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager ().beginTransaction ().replace (R.id.lower_fragment,fragment).commit ();

            return  true;
        }
        return  false;
    }

    public String getCategory(){
        return category;
    }
}
