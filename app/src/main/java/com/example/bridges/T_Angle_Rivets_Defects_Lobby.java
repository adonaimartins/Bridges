package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class T_Angle_Rivets_Defects_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t__angle__rivets__defects__lobby);
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, T_Angle_Rivets_Defects_Form.class);
        startActivity(intent);
    }

    public void deleteDefect(View view) {
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Stiffener_Lobby.class);
        startActivity(intent);
    }
}