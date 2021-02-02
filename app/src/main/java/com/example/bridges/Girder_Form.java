package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Girder_Form extends AppCompatActivity{

    private Dropdown dropDown_bays_direction; //these dropdown can get the data from the spinners
    private Dropdown dropDown_elevation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girder__form);

        ArrayAdapter bays_direction_items = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.baysDirection));//resourseNameArray
        Dropdown dropDown_bays_direction = new Dropdown("Select Direction");
        dropDown_bays_direction.addSpinnerValues(findViewById(R.id.dropDown_bays_direction_p49), bays_direction_items );

        ArrayAdapter elevation_items = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.elevation));//resourseNameArray
        Dropdown dropDown_elevation = new Dropdown("Select Elevation");
        dropDown_elevation.addSpinnerValues(findViewById(R.id.dropDown_elevation_p49), elevation_items );

    }

    public void submit(View view) {
        Intent intent = new Intent(this, Girders_Lobby.class);
        startActivity(intent);
    }



}