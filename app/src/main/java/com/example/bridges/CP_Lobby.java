package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CP_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p__lobby);
    }

    public void launchDefects(View view) {
        Intent intent = new Intent(this, CP_Defects_Lobby.class);
        startActivity(intent);
    }

    public void launchRivetsDefects(View view) {
        Intent intent = new Intent(this, CP_Rivets_Defects_Lobby.class);
        startActivity(intent);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, CP_List_Lobby.class);
        startActivity(intent);
    }
}