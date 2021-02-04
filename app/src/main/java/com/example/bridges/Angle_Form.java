package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Angle_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_position = new Dropdown("Select Position");
    private Dropdown dropDown_length_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_height_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_width_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_thickness_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_headSize_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_longitudinalSpacing_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing1_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing2_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_verticalSpacing1_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_verticalSpacing2_inchesToMm = new Dropdown("Select Unit");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle__form);

        ArrayAdapter position_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.positionToBottom));
        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_position.addSpinnerValues(findViewById(R.id.dropdown_Position_p3), position_items);
        dropDown_length_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_length_p3), inchesToMm_items);
        dropDown_height_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_height_p3), inchesToMm_items);
        dropDown_width_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_width_p3), inchesToMm_items);
        dropDown_thickness_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_thickness_p3), inchesToMm_items);
        dropDown_headSize_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_head_size_p3), inchesToMm_items);
        dropDown_longitudinalSpacing_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_longitudinal_spacing_p3), inchesToMm_items);
        dropDown_transverseSpacing1_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing1_p3), inchesToMm_items);
        dropDown_transverseSpacing2_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing2_p3), inchesToMm_items);
        dropDown_verticalSpacing1_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_vertical_spacing1_p3), inchesToMm_items);
        dropDown_verticalSpacing2_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_vertical_spacing_2_p3), inchesToMm_items);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Angle_Lobby.class);
        startActivity(intent);
    }
}