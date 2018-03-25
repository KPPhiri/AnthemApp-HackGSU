package com.example.philipphiri.hackgsuanthemapp;

import android.content.Intent;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
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
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    boolean buttonNewResponse = false;
    Button submit;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji_response);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mTog);
        mTog.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        emoji = (ImageView) findViewById(R.id.emoji_imageView);
        emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
        button1 = (Button) findViewById(R.id.response1);
        button2 = (Button) findViewById(R.id.response2);
        button3 = (Button) findViewById(R.id.response3);
        button4 = (Button) findViewById(R.id.response4);
        button4.setText("Enter your own response.");

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonNewResponse = true;
            }
        });
        if (butOne == false) {
            emoji.setImageResource(R.drawable.emoji1);

            emoji_emotion.setText("Exhausted");

            button1.setText("The system is continuously having errors.");
            button2.setText("I do not feel respected at my workplace.");
            button3.setText("Conflicts within the team are not getting fixed.");

        } else if (butTwo == false) {
            emoji.setImageResource(R.drawable.emoji2);

            emoji_emotion.setText("Anxious");

            button1.setText("The system has an error.");
            button2.setText("I feel as though my work is not being used efficiently.");
            button3.setText("I had a unresolved conflict with my manager or coworker.");
        } else if (butThree == false) {
            emoji.setImageResource(R.drawable.emoji3);

            emoji_emotion.setText("Content");

            button1.setText("I have not run into any issues with the app.");
            button2.setText("I am contributing to my team and my company.");
            button3.setText("My relationships with my coworkers and manager are healthy.");
        } else if (butFour == false) {
            emoji.setImageResource(R.drawable.emoji4);

            emoji_emotion.setText("Happy");

            button1.setText("The app is useful and I want to use it again.");
            button2.setText("I enjoy working with my team.");
            button3.setText("My company is a great fit for me.");
        } else if (butFive == false) {
            emoji.setImageResource(R.drawable.emoji5);

            emoji_emotion.setText("Excited");

            button1.setText("The app is great and very helpful!");
            button2.setText("I couldn't ask for a better team!");
            button3.setText("I am excited for the opportunities at my company.");
        }

        submit = (Button)findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (buttonNewResponse) {
                    startActivity(new Intent(emoji_response.this, elaborate_activity.class));
                } else {
                    startActivity(new Intent(emoji_response.this, Feed_Activity.class));
                }
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
