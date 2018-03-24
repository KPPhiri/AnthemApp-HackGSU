package com.example.philipphiri.hackgsuanthemapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butFive;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butFour;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butOne;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butThree;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butTwo;

public class emoji_response extends AppCompatActivity {

    ImageView emoji;
    TextView emoji_emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji_response);
        if (butOne == false) {
            emoji = (ImageView) findViewById(R.id.emoji_imageView);
            emoji.setImageResource(R.drawable.emoji1);

            emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
            emoji_emotion.setText("Exhausted");

        } else if (butTwo == false) {
            emoji = (ImageView) findViewById(R.id.emoji_imageView);
            emoji.setImageResource(R.drawable.emoji2);

            emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
            emoji_emotion.setText("Anxious");
        } else if (butThree == false) {
            emoji = (ImageView) findViewById(R.id.emoji_imageView);
            emoji.setImageResource(R.drawable.emoji3);

            emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
            emoji_emotion.setText("Content");
        } else if (butFour == false) {
            emoji = (ImageView) findViewById(R.id.emoji_imageView);
            emoji.setImageResource(R.drawable.emoji4);

            emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
            emoji_emotion.setText("Happy");
        } else if (butFive == false) {
            emoji = (ImageView) findViewById(R.id.emoji_imageView);
            emoji.setImageResource(R.drawable.emoji5);

            emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
            emoji_emotion.setText("Excited");
        }
    }
}
