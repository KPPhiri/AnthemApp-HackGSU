package com.example.philipphiri.hackgsuanthemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class elaborate_activity extends AppCompatActivity {
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        next = findViewById(R.id.next_button);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elaborate_activity);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(elaborate_activity.this, Vitals_Activity.class));

            }
        });
    }



}
