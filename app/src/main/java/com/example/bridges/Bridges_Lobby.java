package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bridges_Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridges_lobby);
    }

    public void addBridge(View view) {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    public void deleteBridge(View view) {
        //////needs to  be done
    }

    public void EditBridge(View view) {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}