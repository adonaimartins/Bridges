package com.example.bridges;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.example.bridges.recyclerAdapters.BridgeAdapter;
import com.example.bridges.recyclerAdapters.BridgeAdapter2;
import com.example.bridges.viewModel.BridgesViewModel;

import java.util.ArrayList;
import java.util.List;

public class Bridges_Lobby extends AppCompatActivity {

    //public static final int ADD_NOTE_REQUEST = 1; //request data from the form activity when added
    //public static final int EDIT_NOTE_REQUEST = 1 << 1; // request data from the activity when edited


    RecyclerView recyclerView;
    BridgesViewModel bridgesViewModel; //this is for the database
    List<Bridges> allBridges; //this is for testing - delete later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridges_lobby);
        //final BridgeAdapter bridgeAdapter = new BridgeAdapter();
        final BridgeAdapter2 bridgeAdapter2 = new BridgeAdapter2(new ArrayList<Bridges>());


        bridgesViewModel = ViewModelProviders.of(this).get(BridgesViewModel.class);
        loadTableData();//testing method

        recyclerView = findViewById(R.id.bridges_data_p12);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(bridgeAdapter);
        //System.out.println("SPACE");

      //  System.out.println(allBridges.toString());
        //LiveData<List<Bridges>> bridgesList = bridgesViewModel.getAllBridges();
       // System.out.println("aqui" + bridgesList);
        //bridgeAdapter.submitList(allBridges);
        recyclerView.setAdapter(bridgeAdapter2);
        //ridgeAdapter2.setBridgesList();

        System.out.println(" bridge name ");

        bridgesViewModel.getAllBridges().observe(this, new Observer<List<Bridges>>() {
            @Override
            public void onChanged(List<Bridges> bridgesList) {

                System.out.println(" bridge name " + bridgesList.size());

                bridgeAdapter2.setBridgesList(bridgesList);
                bridgeAdapter2.notifyDataSetChanged();
/*
                bridgeAdapter.submitList(bridgesList);
                System.out.println(" bridge aqui " + bridgesList.size());
                //allBridges.addAll(bridgesList);
*/

            }
        });


        //idgeAdapter.notifyDataSetChanged();

        //bridgeAdapter.submitList(allBridges);


        bridgeAdapter2.setEditOnClickListener(new BridgeAdapter2.OnItemClickListener() {
            @Override
            public void onItemClickListener(Bridges bridge) {/*
                Intent intent = new Intent(Bridges_Lobby.this, Bridge_Form.class);
                intent.putExtra(Bridge_Form.EXTRA_ID, bridge.getBridge_id());
                startActivity(intent);*/
               // bridgesViewModel.delete(bridgeAdapter.getBridgesAt(viewHolder.getAdapterPosition()));
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
        //loadTableData();
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