package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class T_Angle_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_length_inchesToM = new Dropdown("Select Unit");
    private Dropdown dropDown_height_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_widthTop_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_widthBottom_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_thickness_inchesToMm = new Dropdown("Select Unit");


    private Dropdown dropDown_headSize_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_longitudinalSpacing_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing1_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing2_inchesToMm = new Dropdown("Select Unit");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t__angle__form);


        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_length_inchesToM.addSpinnerValues(findViewById(R.id.inchesMilimetre1_p43), inchesToMm_items);
        dropDown_height_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre2_p43), inchesToMm_items);
        dropDown_widthTop_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre3_p43), inchesToMm_items);
        dropDown_widthBottom_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre4_p43), inchesToMm_items);
        dropDown_thickness_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre5_p43), inchesToMm_items);

        dropDown_headSize_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_head_size_p43), inchesToMm_items);
        dropDown_longitudinalSpacing_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_longitudinal_spacing_p43), inchesToMm_items);
        dropDown_transverseSpacing1_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing1_p43), inchesToMm_items);
        dropDown_transverseSpacing2_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing2_p43), inchesToMm_items);
    }

    public void next(View view) {
        Intent intent = new Intent(this, T_Angle_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }
}