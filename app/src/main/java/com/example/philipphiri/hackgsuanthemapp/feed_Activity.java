package com.example.philipphiri.hackgsuanthemapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class feed_Activity extends AppCompatActivity {


    private Button filter;
    FirebaseAuth user;
    DatabaseReference userData;

    ListView listViewResponse;
    List<Response> responses;
    DatabaseReference databaseResponse;
    NDSpinner filters;
    ResponseAdapter shelterAdapter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_list);
        Intent intent = getIntent();

        //ref of shelters node
        databaseResponse = FirebaseDatabase.getInstance().getReference("Responses");
        //getting views
        listViewResponse = (ListView) findViewById(R.id.listViewResponse);
        listViewResponse.setTextFilterEnabled(true);
        responses = new ArrayList<>();

        ArrayAdapter<Filter> filterAdapter = new ArrayAdapter<Filter> (this, android.R.layout.simple_spinner_item,
                Filter.values());
        filterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        filters.setAdapter(filterAdapter);

        filters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        //getting current user's info
        user = FirebaseAuth.getInstance();
        userData = FirebaseDatabase.getInstance().getReference().child("Users");

        listViewResponse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Response r = (Response) listViewResponse.getItemAtPosition(position);
                ShowDetails(v,s);
            }
        });

    }


    private void showEntireList() {
        shelterAdapter.noFilter();
    }

    protected void onStart() {
        super.onStart();
        databaseShelters.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                shelters.clear();

                for (DataSnapshot tuple: dataSnapshot.getChildren()) {
                    Response shelter = new Reponse((String) tuple.child("Address").getValue(),(String) tuple.child("Capacity").getValue(), Double.parseDouble((String)tuple.child("Latitude ").getValue()),
                            Double.parseDouble((String) tuple.child("Longitude ").getValue()), (String)tuple.child("Phone Number").getValue(), (String) tuple.child("Restrictions").getValue(),
                            (String) tuple.child("Shelter Name").getValue(), (String)tuple.child("Special Notes").getValue(), (String) tuple.child("Unique Key").getValue());
                    //Shelter shelter = tuple.getValue(Shelter.class);
                    shelters.add(shelter);
                }
                //creating adapter
                shelterAdapter = new ShelterList(ShelterListActivity.this, shelters);
                //attaching adapter to the listview
                listViewShelters.setAdapter(shelterAdapter);


                final EditText searchET = (EditText)findViewById(R.id.searchBar);
                // Capture Text in EditText
                searchET.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void afterTextChanged(Editable arg0) {
                        // TODO Auto-generated method stub
                        String text = searchET.getText().toString().toLowerCase(Locale.getDefault());
                        shelterAdapter.filter(text);
                    }

                    @Override
                    public void beforeTextChanged(CharSequence arg0 , int arg1,
                                                  int arg2, int arg3) {
                        // TODO Auto-generated method stub
                    }


                    @Override
                    public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                        // TODO Auto-generated method stub
                    }
                });
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
