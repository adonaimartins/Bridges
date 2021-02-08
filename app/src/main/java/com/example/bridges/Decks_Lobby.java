package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Decks_Lobby extends AppCompatActivity {

    TableLayout table;
    Button addGirder; //MAY NOT BE NEEDED
    Button submit;//MAY NOT BE NEEDED

    List<List<String>> decks = new ArrayList<List<String>>();

    List<String> deck1 = new ArrayList<String>();
    List<String> deck2 = new ArrayList<String>();
    List<String> deck3 = new ArrayList<String>();
    List<String> deck4 = new ArrayList<String>();

    int deckCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decks_lobby);

        table = findViewById(R.id.tableDecks_p20);
       // addGirder = findViewById(R.id.buttonAddGirder_p28);
       // submit.findViewById(R.id.button_submit_p20);

        deck1.add("1");
        deck1.add("true");
        deck2.add("2");
        deck2.add("true");
        deck3.add("3");
        deck3.add("true");
        deck4.add("4");
        deck4.add("false");

        decks.add(deck1);
        decks.add(deck2);
        decks.add(deck3);
        decks.add(deck4);
        deckCounter = 1;
        loadDecks();

    }

    private void addDeckRow( int id, boolean checkCompleted) {


        View row = getLayoutInflater().inflate(R.layout.table_deck_row, null, false);

        TextView deckNumber = (TextView)row.findViewById(R.id.row_deckId_p20);
        CheckBox deckStatus = (CheckBox)row.findViewById(R.id.row_status_p20);
        Button editDeck = (Button)row.findViewById(R.id.edit_deck_p20);
        Button deleteDeck = (Button)row.findViewById(R.id.delete_deck_p20);

        deckNumber.setText(Integer.toString(id));
        deckStatus.setChecked(checkCompleted);
        editDeck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editDeck(v);
            }
        });

        deleteDeck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteDeck(row);
            }
        });
        table.addView(row);
        deckCounter++;
    }
    private void loadDecks() {
        for (int index = 0; index < decks.size(); index++){
        boolean checker = false;
            if(decks.get(index).get(1).equals("true")){
                checker = true;
            }
            addDeckRow(Integer.parseInt(decks.get(index).get(0)), checker);
        }
    }
    public void deleteDeck(View view) {
        TextView rowId = (TextView)view.findViewById(R.id.row_deckId_p20);
        if(Integer.parseInt(rowId.getText().toString()) == deckCounter -1 ){
            deckCounter--;
        }
        table.removeView(view);
    }
    public void editDeck(View view) {
        Intent intent = new Intent(this, Girders_Lobby.class);
        startActivity(intent);
    }
    public void submit(View view) {
        Intent intent = new Intent(this, Bridges_Lobby.class);
        startActivity(intent);
    }
    public void addDeck(View view) {
        addDeckRow(deckCounter, false);
    }
}