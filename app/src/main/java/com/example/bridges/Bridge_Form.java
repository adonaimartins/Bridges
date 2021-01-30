package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bridge_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge_form);
    }

    public void launchDeckLobby(View view) {
        Intent intent = new Intent(this, Decks_Lobby.class);
        startActivity(intent);
    }
}