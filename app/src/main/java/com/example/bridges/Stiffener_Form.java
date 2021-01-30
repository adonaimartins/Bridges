package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stiffener_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiffener_form);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Stiffener_Lobby.class);
        startActivity(intent);
    }
}