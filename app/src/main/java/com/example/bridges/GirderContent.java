package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GirderContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girder_content);
    }

    public void launchWebForm(View view) {
        Intent intent = new Intent(this, Web_Form.class);
        startActivity(intent);
    }

    public void launchAngleForm(View view) {
        Intent intent = new Intent(this, Angle_Form.class);
        startActivity(intent);
    }

    public void launchBays(View view) {
        Intent intent = new Intent(this, Bays_Lobby.class);
        startActivity(intent);
    }

    public void launch_CP_List(View view) {
        Intent intent = new Intent(this, CP_List_Lobby.class);
        startActivity(intent);
    }

    public void launchFlangeForm(View view) {
        Intent intent = new Intent(this, Flange_Form.class);
        startActivity(intent);
    }

    public void submitGirder(View view) {
        Intent intent = new Intent(this, Girders_Lobby.class);
        startActivity(intent);
    }
}