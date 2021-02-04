package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Angle_Defects_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_defect_type = new Dropdown("Select Elevation");
    private Dropdown dropDown_leg = new Dropdown("Select Elevation");
    private Dropdown dropDown_position = new Dropdown("Select Position");
    private Dropdown dropDown_elevation = new Dropdown("Select Elevation");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle__defects__form);


        ArrayAdapter defect_type_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectType_1));
        ArrayAdapter leg_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectLeg));
        ArrayAdapter position_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectPosition));
        ArrayAdapter elevation_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.elevation));

        dropDown_defect_type.addSpinnerValues(findViewById(R.id.dropDown_defect_type_p1), defect_type_items );
        dropDown_leg.addSpinnerValues(findViewById(R.id.dropDown_leg_p1), leg_items );
        dropDown_position.addSpinnerValues(findViewById(R.id.dropdown_Position_p1), position_items );
        dropDown_elevation.addSpinnerValues(findViewById(R.id.dropDown_elevation_p1), elevation_items );
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, Angle_Defects_Lobby.class);
        startActivity(intent);
    }
}