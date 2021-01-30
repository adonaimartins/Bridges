package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Web_Defects_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__defects__lobby);
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, Web_Defects_Form.class);
        startActivity(intent);
    }

    public void deleteDefect(View view) {
    }

    public void submit(View view) {
        Intent intent = new Intent(this, GirderContent.class);
        startActivity(intent);
    }
}