package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class CP_Defects_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_defectType = new Dropdown("Select Position");
    private Dropdown dropDown_elevation = new Dropdown("Select Unit");
    private Dropdown dropDown_methodOfMeasurement = new Dropdown("Select Unit");

    private Dropdown dropDown_startLength_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_endLength_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_length_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_startWidth_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_endWidth_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_width_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_depth_inchesToMm = new Dropdown("Select Unit");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p__defects__form);


        ArrayAdapter defectType_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectType_1));
        ArrayAdapter elevation_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.elevation));
        ArrayAdapter methodOfMeasurement_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.methodOfMeasurement));

        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_defectType.addSpinnerValues(findViewById(R.id.dropdownTypeOfDefect_p13), defectType_items);
        dropDown_elevation.addSpinnerValues(findViewById(R.id.dropDown_elevation_p13), elevation_items);
        dropDown_methodOfMeasurement.addSpinnerValues(findViewById(R.id.dropDown_method_for_measurement_p13), methodOfMeasurement_items);

    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, CP_Defects_Lobby.class);
        startActivity(intent);
    }
}