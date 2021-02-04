package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Web_Defects_Form extends AppCompatActivity {

    //object that adds data to spinners
    private Dropdown dropDown_defectType = new Dropdown("Select Unit");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__defects_form);

        ArrayAdapter defectType_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.defectType_2));

        ArrayAdapter inchesToMm_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.inchesMm));

        dropDown_defectType.addSpinnerValues(findViewById(R.id.dropDown_defect_type_p47), defectType_items);


    }

    public void submit(View view) {
        Intent intent = new Intent(this, Web_Defects_Lobby.class);
        startActivity(intent);
    }
}