package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Decks")

public class Deck {

    @PrimaryKey(autoGenerate = true)
    private int deck_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int bridge_id;// int NOT NULL,			FOREIGN KEY (bridge_id) REFERENCES Bridges(bridge_id)
    private int deck_number;
}
