package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Stiffener_Rivets_Form extends AppCompatActivity {

    private Dropdown dropDown_headSize_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_longitudinalSpacing_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing1_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_transverseSpacing2_inchesToMm = new Dropdown("Select Unit");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiffener__rivets__form);

        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_headSize_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_head_size_p39), inchesToMm_items);
        dropDown_longitudinalSpacing_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_longitudinal_spacing_p39), inchesToMm_items);
        dropDown_transverseSpacing1_inchesToMm.addSpinnerValues(findViewById(R.id.dropDown_transverse_spacing1_p39), inchesToMm_items);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Stiffener_Rivets_Defects_Lobby.class);
        startActivity(intent);



    }
}