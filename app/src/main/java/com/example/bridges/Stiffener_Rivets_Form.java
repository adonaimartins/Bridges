package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stiffener_Rivets_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiffener__rivets__form);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Stiffener_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }
}