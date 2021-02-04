package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class Flange_Rivets_Defects_Form extends AppCompatActivity {

    private Dropdown dropDown_position = new Dropdown("Select Defect Type");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flange__rivets__defects__form);

        ArrayAdapter position_items = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rivetsDefect));

        dropDown_position.addSpinnerValues(findViewById(R.id.dropDown_defect_type_p25), position_items);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Flange_Rivets_Defects_Lobby.class);
        startActivity(intent);

    }
}