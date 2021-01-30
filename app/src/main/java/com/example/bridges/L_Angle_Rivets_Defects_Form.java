package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class L_Angle_Rivets_Defects_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l__angle__rivets__defects__form);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, L_Angle_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }
}