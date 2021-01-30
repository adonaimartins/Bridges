package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Web_Defects_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__defects_form);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Web_Defects_Lobby.class);
        startActivity(intent);
    }
}