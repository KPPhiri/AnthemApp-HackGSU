package com.example.philipphiri.hackgsuanthemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class elaborate_activity extends AppCompatActivity {
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elaborate_activity);
        nextBtn = findViewById(R.id.next_button);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(elaborate_activity.this, Feed_Activity.class));

            }
        });
    }



}
