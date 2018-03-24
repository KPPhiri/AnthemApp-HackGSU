package com.example.philipphiri.hackgsuanthemapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton one, two, three, four, five;
    private boolean butOne, butTwo, butThree, butFour, butFive;
    private List<ImageButton> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (ImageButton) findViewById(R.id.imageButton1);
        two = (ImageButton) findViewById(R.id.imageButton2);
        three = (ImageButton) findViewById(R.id.imageButton3);
        four = (ImageButton) findViewById(R.id.imageButton4);
        five = (ImageButton) findViewById(R.id.imageButton5);

        buttons = new ArrayList<>();
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);

        butOne = true;
        butTwo = true;
        butThree = true;
        butFour = true;
        butFive = true;



//
//
//        one.setOnClickListener(new View.OnClickListener()
//        {
//
//            @Override
//            public void onClick(View v) {
//                if (off) {
//                    float x = (float) 1.25;
//                    float y = (float) 1.25;
//
//                    one.setScaleX(x);
//                    one.setScaleY(y);
//                    one.setBackgroundResource(R.drawable.one);
//                    off = false;
//                } else {
//                    float x = 1;
//                    float y = 1;
//
//                    one.setScaleX(x);
//                    one.setScaleY(y);
//                    one.setBackgroundResource(R.drawable.one);
//
//
//                    off = true;
//                }
//            }
//        });
//
//
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageButton1) {
           enlarge(R.drawable.one, view.getId(), butOne);
           //Lod.id("working", working);
            butOne = !butOne;
            butTwo = true;
            butThree = true;
            butFour = true;
            butFive = true;
        }

    }

    private void enlarge(int background, int id, boolean bbutton)  {
        if (bbutton) {
            float x = (float) 1.25;
            float y = (float) 1.25;

            one.setScaleX(x);
            one.setScaleY(y);
            one.setBackgroundResource(background);
        } else {
            float x = 1;
            float y = 1;

            one.setScaleX(x);
            one.setScaleY(y);
            one.setBackgroundResource(background);
        }

        for(ImageButton button: buttons) {
            if(button.getId() != id) {
                float x = 1;
                float y = 1;

                one.setScaleX(x);
                one.setScaleY(y);
                one.setBackgroundResource(background);
            }
        }
    }

}
