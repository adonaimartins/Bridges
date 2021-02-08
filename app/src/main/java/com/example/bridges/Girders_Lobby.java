package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Girders_Lobby extends AppCompatActivity  {

    TableLayout girderTable;
    List<String> girder1 = new ArrayList<String>();
    List<String> girder2 = new ArrayList<String>();
    List<String> girder3 = new ArrayList<String>();

    List<List<String>> girders = new ArrayList<List<String>>();
    int girderCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girders_lobby);

        girderTable = (TableLayout)findViewById(R.id.girdersTable_p28);

        girder1.add("1");
        girder1.add("MGE1");
        girder1.add("10");
        girder1.add("true");

        girder2.add("2");
        girder2.add("MTE2");
        girder2.add("10");
        girder2.add("true");

        girder3.add("3");
        girder3.add("MVE10");
        girder3.add("10");
        girder3.add("false");

        girders.add(girder1);
        girders.add(girder2);
        girders.add(girder3);

        girderCounter = 1;

        loadGirders(girders);

    }

    private void loadGirders(List<List<String>> girders) {
        for (int index = 0; index < girders.size(); index++){
            addGirderRow(girders.get(index));
        }
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
        TextView rowId = (TextView)view.findViewById(R.id.row_deckId_p20);
        if(Integer.parseInt(rowId.getText().toString()) == girderCounter -1 ){
            girderCounter--;
        }
        girderTable.removeView(view);
    }
    public void submitGirder(View view) {
        Intent intent = new Intent(this, Decks_Lobby.class);
        startActivity(intent);
    }

    private void addGirderRow(List<String> rowItems){
        View girderRow = getLayoutInflater().inflate(R.layout.table_girder_row, null, false);

        TextView girderId = (TextView)girderRow.findViewById(R.id.girderId_p28);
        TextView girderName = (TextView)girderRow.findViewById(R.id.girderName_p28);
        TextView numberOfBays = (TextView)girderRow.findViewById(R.id.girderBaysQty_p28);
        CheckBox girderDoneCheck = (CheckBox)girderRow.findViewById(R.id.girderDoneCheck_p28);
        Button editGirder = (Button)girderRow.findViewById(R.id.table_button_edit_p28);
        Button deleteGirder = (Button)girderRow.findViewById(R.id.table_button_del_p28);


        girderId.setText(rowItems.get(0));
        girderName.setText(rowItems.get(1));
        numberOfBays.setText(rowItems.get(2));

        if(rowItems.get(3).equals("true")){
            girderDoneCheck.setChecked(true);
        }

        editGirder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGirder(girderRow);
            }
        });
        deleteGirder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                deleteGirder(girderRow);
            }
        });

        girderTable.addView(girderRow);
        girderCounter++;
    }
}