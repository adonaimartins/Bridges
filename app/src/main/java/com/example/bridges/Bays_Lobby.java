package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Bays_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_bays_lobby);
    }

    public void launchStiffenerForm(View view) {
        //need to get the id here to add
        Intent intent = new Intent(this, Stiffener_Form.class);
        startActivity(intent);
    }

    public void submit(View view) {

        Intent intent = new Intent(this, GirderContent.class);
        startActivity(intent);
    }
}