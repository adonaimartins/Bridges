package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Angle_Rivets_Defects_Form extends AppCompatActivity {

    private Dropdown dropDown_position = new Dropdown("Select Defect Type");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle__rivets__defects__form);



        ArrayAdapter position_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rivetsDefect));

        dropDown_position.addSpinnerValues(findViewById(R.id.dropDown_defect_type_p5), position_items);
        //rivetsDefect
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Angle_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }
}