package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stiffener_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiffener_lobby);
    }

    public void launchRivets(View view) {
        Intent intent = new Intent(this, Stiffener_Rivets_Form.class);
        startActivity(intent);
    }

    public void launchDefects(View view) {
        Intent intent = new Intent(this, Stiffener_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }

    public void launch_L_Angle(View view) {
        Intent intent = new Intent(this, L_Angle_Form.class);
        startActivity(intent);
    }

    public void launch_T_Angle(View view) {
        Intent intent = new Intent(this, T_Angle_Form.class);
        startActivity(intent);
    }

    public void launchB2B_L_Angle(View view) {
        Intent intent = new Intent(this, B2B_L_Angle_Form.class);
        startActivity(intent);
    }

    public void launchGussetPlate(View view) {
        Intent intent = new Intent(this, Gusset_Plates_Form.class);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Bays_Lobby.class);
        startActivity(intent);
    }
}