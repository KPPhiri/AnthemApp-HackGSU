package com.example.philipphiri.hackgsuanthemapp;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class FeedActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mTog);
        mTog.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //code
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mTog.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
