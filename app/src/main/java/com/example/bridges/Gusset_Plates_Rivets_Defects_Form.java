package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Gusset_Plates_Rivets_Defects_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gusset__plates__rivets__defects__form);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Gusset_Plates_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }
}