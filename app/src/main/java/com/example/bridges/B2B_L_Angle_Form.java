package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class B2B_L_Angle_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2_b__l__angle__form);
    }

    public void next(View view) {
        Intent intent = new Intent(this, B2B_L_Angle_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }
}