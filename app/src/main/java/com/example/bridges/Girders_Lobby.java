package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Girders_Lobby extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girders_lobby);

    }


    public void addGirder(View view) {
        Intent intent = new Intent(this, Girder_Form.class);
        startActivity(intent);
    }


    public void editGirder(View view) {
        Intent intent = new Intent(this, GirderContent.class);
        startActivity(intent);
    }
    public void deleteGirder(View view) {

    }
    public void submitGirder(View view) {
        Intent intent = new Intent(this, Decks_Lobby.class);
        startActivity(intent);
    }




}