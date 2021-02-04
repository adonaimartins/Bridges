package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Flange_Defects_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_defectType = new Dropdown("Select Position");
    private Dropdown dropDown_elevation = new Dropdown("Select Unit");

    private Dropdown dropDown_methodOfMeasurement = new Dropdown("Select Unit");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flange__defects__form);

        ArrayAdapter defectType_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectType_1));
        ArrayAdapter elevation_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.elevation));
        ArrayAdapter methodOfMeasurement_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.methodOfMeasurement));

        dropDown_defectType.addSpinnerValues(findViewById(R.id.dropDown_defect_type_p21), defectType_items);
        dropDown_elevation.addSpinnerValues(findViewById(R.id.dropdown_Position_p21), elevation_items);
        dropDown_methodOfMeasurement.addSpinnerValues(findViewById(R.id.dropDown_option_chosen_p21), methodOfMeasurement_items);


    }

    public void add(View view) {
        Intent intent = new Intent(this, Flange_Defects_Lobby.class);
        startActivity(intent);
    }
}