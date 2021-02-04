package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Flange_Form extends AppCompatActivity {


    //object that adds data to spinners
    private Dropdown dropDown_position = new Dropdown("Select Position");
    private Dropdown dropDown_width_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_thickness_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_headSize_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_longitudinalSpacing_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing1_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing2_inchesToMm = new Dropdown("Select Unit");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flange__form);

        ArrayAdapter position_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.positionToBottom));
        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_position.addSpinnerValues(findViewById(R.id.dropdown_Position_p23), position_items);
        dropDown_width_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_width_p23), inchesToMm_items);
        dropDown_thickness_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_thickness_p23), inchesToMm_items);
        dropDown_headSize_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_head_size_p23), inchesToMm_items);
        dropDown_longitudinalSpacing_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_longitudinal_spacing_p23), inchesToMm_items);
        dropDown_transverseSpacing1_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing1_p23), inchesToMm_items);
        dropDown_transverseSpacing2_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing2_p23), inchesToMm_items);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Flange_Lobby.class);
        startActivity(intent);

    }
}