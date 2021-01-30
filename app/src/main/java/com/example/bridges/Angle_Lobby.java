package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Angle_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle__lobby);
    }

    public void launchRivetsDefects(View view) {
        Intent intent = new Intent(this, Angle_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }

    public void launchDefects(View view) {
        Intent intent = new Intent(this, Angle_Defects_Lobby.class);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, GirderContent.class);
        startActivity(intent);
    }

}