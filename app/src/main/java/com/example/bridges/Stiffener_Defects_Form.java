package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Stiffener_Defects_Form extends AppCompatActivity {
    //object that adds data to spinners
    private Dropdown dropDown_defectType = new Dropdown("Select Defect Type");
    private Dropdown dropDown_elevation = new Dropdown("Select Elevation");

    private Dropdown dropDown_measurementFrom = new Dropdown("Select Measurement From");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiffener__defects__form);

        ArrayAdapter defectType_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectType_1));
        ArrayAdapter elevation_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.elevation));
        ArrayAdapter measurementFrom_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.measurementFrom));

        dropDown_defectType.addSpinnerValues(findViewById(R.id.dropDown_defect_type_p36), defectType_items);
        dropDown_elevation.addSpinnerValues(findViewById(R.id.dropDown_leg_p36), elevation_items);
        dropDown_measurementFrom.addSpinnerValues(findViewById(R.id.dropDown_measurement_from_p36), measurementFrom_items);
    }



    public void submit(View view) {
        Intent intent = new Intent(this, Stiffener_Defects_Lobby.class);
        startActivity(intent);
    }
}