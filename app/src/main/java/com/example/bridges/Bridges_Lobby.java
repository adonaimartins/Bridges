package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.example.bridges.recyclerAdapters.BridgeAdapter;
import com.example.bridges.viewModel.BridgesViewModel;

import java.util.ArrayList;
import java.util.List;

public class Bridges_Lobby extends AppCompatActivity {

    RecyclerView recyclerView;
    BridgesViewModel bridgesViewModel; //this is for the database



    List<Bridges> allBridges; //this is for testing - delete later
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridges_lobby);
        final BridgeAdapter bridgeAdapter = new BridgeAdapter();
       // bridgesViewModel = ViewModelProviders.of(this).get(BridgesViewModel.class);
        loadTableData();//testing method


        recyclerView = findViewById(R.id.bridges_data_p12);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(bridgeAdapter);

        bridgeAdapter.submitList(allBridges); //testing method

        /*
        bridgesViewModel.getAllBridges().observe(this, new Observer<List<Bridges>>() {
            @Override
            public void onChanged(List<Bridges> bridges) {
                bridgeAdapter.submitList(bridges);
            }
        });

*/

        bridgeAdapter.setEditOnClickListener(new BridgeAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(Bridges bridge) {


               // bridgesViewModel.delete(bridgeAdapter.getBridgesAt(viewHolder.getAdapterPosition()));
                Toast.makeText(Bridges_Lobby.this, "Note Edited ", Toast.LENGTH_SHORT).show();
            }
        });

        bridgeAdapter.setDeleteOnClickListener(new BridgeAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(Bridges bridge) {


               // bridgesViewModel.delete(bridgeAdapter.getBridgesAt(viewHolder.getAdapterPosition()));
                Toast.makeText(Bridges_Lobby.this, "Note Deleted ", Toast.LENGTH_SHORT).show();
            }
        });
        loadTableData();
    }


    public void addBridge(View view) {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

/*
    private void addRow(List<String> bridgeList){

        View row = getLayoutInflater().inflate(R.layout.table_bridge_row, null, false);

        TextView bridgeIdView = (TextView)row.findViewById(R.id.row_bridgeId) ;
        TextView bridgeNameView = (TextView)row.findViewById(R.id.row_bridge_name);
        TextView locationView = (TextView)row.findViewById(R.id.row_bridge_location);
        TextView bridgeNumberView = (TextView)row.findViewById(R.id.row_bridge_number);
        Button buttonDelete  = (Button)row.findViewById(R.id.row_deleteBridge);
        Button buttonEdit = (Button)row.findViewById(R.id.row_editBridge);

        bridgeIdView.setText(bridgeList.get(0));
        bridgeNameView.setText(bridgeList.get(1));
        locationView.setText(bridgeList.get(2));
        bridgeNumberView.setText(bridgeList.get(3));

        buttonEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editBridge();
                //need to pass which bridge will be needed
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteRow(row);
            }
        });
        bridgesViewModel.addView(row);
    }



   // private void deleteRow(View view) {
        bridgesViewModel.removeView(view);
    }
*/
    private void editBridge() {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void loadTableData(){ //method is for testing, load from database should replace it

        allBridges = new ArrayList<Bridges>();
        Bridges bridge1 = new Bridges(
                "Andy",
                "Duff",
                "Andromeda",
                "La Guaira",
                "AB-1232",
                150,
                1500,
                DatabaseContract.SYNC_STATUS_FAILED);
        Bridges bridge2 = new Bridges(
                "Adonai",
                "Martins",
                "Canal",
                "Leeds",
                "4dddk",
                150,
                1500,
                DatabaseContract.SYNC_STATUS_FAILED);
        Bridges bridge3 = new Bridges(
                "Andy",
                "Duff",
                "London Bridge",
                "London",
                "4UDeck",
                150,
                1500,
                DatabaseContract.SYNC_STATUS_FAILED);

        allBridges.add(bridge1);
        allBridges.add(bridge2);
        allBridges.add(bridge3);


    }

}