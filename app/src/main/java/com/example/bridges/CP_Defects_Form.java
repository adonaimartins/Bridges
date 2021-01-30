package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CP_Defects_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p__defects__form);
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, CP_Defects_Lobby.class);
        startActivity(intent);
    }
}