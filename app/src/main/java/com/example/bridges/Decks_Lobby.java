package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Decks_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks_lobby);
    }

    public void addDeck(View view) {

        //add deck to list
        //refreshes the page
    }

    public void deleteDeck(View view) {
        //deletes the deck from list
        //refreshes the page


    }

    public void editDeck(View view) {
        Intent intent = new Intent(this, Girders_Lobby.class);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Bridges_Lobby.class);
        startActivity(intent);
    }
}