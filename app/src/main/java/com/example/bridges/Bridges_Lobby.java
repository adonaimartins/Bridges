package com.example.bridges;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.example.bridges.httpRequests.HttpRequest;
import com.example.bridges.recyclerAdapters.BridgeAdapter;
import com.example.bridges.recyclerAdapters.BridgeAdapter2;
import com.example.bridges.viewModel.BridgesViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bridges_Lobby extends AppCompatActivity {

    RecyclerView recyclerView;
    BridgesViewModel bridgesViewModel; //this is for the database

    ProgressDialog prgDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridges_lobby);
        final BridgeAdapter2 bridgeAdapter2 = new BridgeAdapter2(new ArrayList<Bridges>());
        bridgesViewModel = ViewModelProviders.of(this).get(BridgesViewModel.class);

        recyclerView = findViewById(R.id.bridges_data_p12);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bridgeAdapter2);

//        bridgesViewModel.getAllNonSyncBridges();

        bridgesViewModel.getAllBridges().observe(this, new Observer<List<Bridges>>() {
            @Override
            public void onChanged(List<Bridges> bridgesList) {
                bridgeAdapter2.setBridgesList(bridgesList);
                bridgeAdapter2.notifyDataSetChanged();
            }
        });

        bridgeAdapter2.setEditOnClickListener(new BridgeAdapter2.OnItemClickListener() {
            @Override
            public void onItemClickListener(Bridges bridge) {
                Intent intent = new Intent(Bridges_Lobby.this, Bridge_Form.class);
                intent.putExtra(Bridge_Form.EXTRA_ID, bridge.getBridge_id());
                startActivity(intent);
                Toast.makeText(Bridges_Lobby.this, "Note Edited ", Toast.LENGTH_SHORT).show();
            }
        });

        bridgeAdapter2.setDeleteOnClickListener(new BridgeAdapter2.OnItemClickListener() {
            @Override
            public void onItemClickListener(Bridges bridge) {
                bridgesViewModel.delete(bridge);
                Toast.makeText(Bridges_Lobby.this, "Note Deleted ", Toast.LENGTH_SHORT).show();
            }
        });

        ///progress dialog properties
        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Synching SQLite Data with Remote MySQL DB. Please wait...");
        prgDialog.setCancelable(false);
    }

    public void addBridge(View view) {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    private void editBridge() {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void syncSQLiteMySQLDB(View view) {
        //Create AsycHttpClient object
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.syncSQLiteMySQLDB(this, bridgesViewModel, prgDialog);

    }
}