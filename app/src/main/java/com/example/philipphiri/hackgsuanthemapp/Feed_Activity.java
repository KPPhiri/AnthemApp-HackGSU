package com.example.philipphiri.hackgsuanthemapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Feed_Activity extends AppCompatActivity {
    ListView listViewComments;
    List<String> comments;
    Button stats;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_);
        initInstances();

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
//        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mTog);
//        mTog.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        comments = new ArrayList<>();
        comments.add("3/20: No I do not feel good working with a manager that talks down at me.");
        comments.add("3/20: I used to take pride in what I did, now I feel like I let the customer down...");
        comments.add("3/21: I will do my best regardless of what I am doing.");
        comments.add("3/22: I'm enjoying the updates to the break room!");
        comments.add("3/22: Stop the favoritism!!!!!!!!!!!!");
        comments.add("3/23: My manager makes me feel like he is always busy and I feel like I am interrupting him");
        comments.add("3/23: Today really proved team work really does make the dream work");
        comments.add("3/23: I look for new jobs daily. Hopefully I will be out of here soon");


        listViewComments = (ListView) findViewById(R.id.commentList);
        stats = (Button) findViewById(R.id.stats);
        listViewComments.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , comments));
        stats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Feed_Activity.this, TeamVitals_Activity.class));
            }
        });
    }
    private void initInstances() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mTog);
        mTog.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigation;

        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.myVitals:
                        startActivity(new Intent(Feed_Activity.this, Vitals_Activity.class));
                        break;
                    case R.id.teamVitals:
                        startActivity(new Intent(Feed_Activity.this, TeamVitals_Activity.class));
                        break;
                    case R.id.companyVitals:
                        startActivity(new Intent(Feed_Activity.this, CompanyVitals_Activity.class));
                        break;
                    case R.id.about:
                        startActivity(new Intent(Feed_Activity.this, aboutPage.class));
                        // add navigation drawer item onclick method here
                        break;
                }
                return false;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mTog.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

