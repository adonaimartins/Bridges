package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class CP_List_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_c_p__list__lobby);
    }

    public void addCP_Plate(View view) {
        Intent intent = new Intent(this, CP_Form.class);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, GirderContent.class);
        startActivity(intent);
    }
}