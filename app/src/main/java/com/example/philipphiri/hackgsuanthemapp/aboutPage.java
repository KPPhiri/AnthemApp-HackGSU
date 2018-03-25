package com.example.philipphiri.hackgsuanthemapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class aboutPage extends AppCompatActivity {

   TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        aboutText = (TextView) findViewById(R.id.aboutText);
        aboutText.setText("Welcome to Anthem Vitals, a place for associates " +
                "to express themselves in their day-to-day. Having a voice is part of what " +
                "makes great teams great and hearing insight from a team, is part of what makes great " +
                "managers great managers. We all have emotions, it is part of what makes us unique and what makes " +
                "each day different.\n\nAnthem Vitals is an associate generated idea, and designed to allow associates to express their " +
                "sentiments, good and bad, with their managers and team. Having a great day after a big win? Let everyone know it! Struggling after " +
                "a particular rough challenge and have an idea for a possible solution next time? Share that too. Anthem" +
                " Vitals allows associates and managers alike, to have a foundation for discussion.");

    }
}
