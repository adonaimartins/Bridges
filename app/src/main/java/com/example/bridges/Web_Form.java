package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Web_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_length_inchesToM = new Dropdown("Select Unit");
    private Dropdown dropDown_height_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_width_inchesToMm = new Dropdown("Select Unit");
    private Dropdown dropDown_thickness_inchesToMm = new Dropdown("Select Unit");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_form);

        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_length_inchesToM.addSpinnerValues(findViewById(R.id.inchesMilimetre1_p48), inchesToMm_items);
        dropDown_height_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre2_p48), inchesToMm_items);
        dropDown_width_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre3_p48), inchesToMm_items);
        dropDown_thickness_inchesToMm.addSpinnerValues(findViewById(R.id.inchesMilimetre4_p48), inchesToMm_items);

    }

    public void next(View view) {
        Intent intent = new Intent(this, Web_Defects_Lobby.class);
        startActivity(intent);
    }
}