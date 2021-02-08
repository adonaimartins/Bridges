package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Bridges_Lobby extends AppCompatActivity {

    TableLayout table;

    List<String> bridge1 = new ArrayList<String>();
    List<String> bridge2 = new ArrayList<String>();
    List<String> bridge3 = new ArrayList<String>();
    List<String> bridge4 = new ArrayList<String>();

    List<List<String>> bridges = new ArrayList<List<String>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridges_lobby);

        table = findViewById(R.id.bridgesTable);
        loadTableData();
    }


    public void addBridge(View view) {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }


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
        table.addView(row);
    }



    private void deleteRow(View view) {
        table.removeView(view);
    }

    private void editBridge() {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void loadTableData(){

        bridge1.add("1");
        bridge1.add("Andromeda");
        bridge1.add("Caracas");
        bridge1.add("4UDeck");
        bridge2.add("2");
        bridge2.add("Canal");
        bridge2.add("Leeds");
        bridge2.add("4dddk");
        bridge3.add("3");
        bridge3.add("London Bridge");
        bridge3.add("London");
        bridge3.add("cuadshhf");

        bridges.add(bridge1);
        bridges.add(bridge2);
        bridges.add(bridge3);
        for (int index = 0; index < bridges.size(); index++){
            addRow(bridges.get(index));
        }
    }

}