package com.example.philipphiri.hackgsuanthemapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Feed_Activity extends AppCompatActivity {
    ListView listViewComments;
    List<String> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_);
        comments = new ArrayList<>();
        comments.add("3/20: I will do my best regardless of what I am doing.");
        comments.add("3/20: I'm enjoying the updates to the break room!");
        comments.add("3/21: No I do not feel good working with a manager that talks down at me.");
        comments.add("3/22: I used to take pride in what I did, now I feel like I let the customer down...");
        comments.add("3/22: Stop the favoritism!!!!!!!!!!!!");
        comments.add("3/23: My manager makes me feel like he is always busy and I feel like I am interrupting him");
        comments.add("3/23: Today really proved team work really does make the dream work");
        comments.add("3/23: I look for new jobs daily. Hopefully I will be out of here soon");




        listViewComments = (ListView) findViewById(R.id.commentList);
        listViewComments.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , comments));



    }

}
