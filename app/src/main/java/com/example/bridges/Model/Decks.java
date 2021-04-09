package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Decks", foreignKeys = @ForeignKey(entity = Bridges.class,
        parentColumns = "bridge_id",
        childColumns = "bridge_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
            @Index(value = {"bridge_id"}, unique = true)}
        )

public class Decks {

    @PrimaryKey(autoGenerate = true)
    private int deck_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int bridge_id;// int NOT NULL,			FOREIGN KEY (bridge_id) REFERENCES Bridges(bridge_id)
    private int deck_number;
    private int sync_status;


    public Decks(int bridge_id, int deck_number, int sync_status) {
        this.bridge_id = bridge_id;
        this.deck_number = deck_number;
        this.sync_status = sync_status;
    }

    public int getDeck_id() {
        return deck_id;
    }

    public int getBridge_id() {
        return bridge_id;
    }

    public int getDeck_number() {
        return deck_number;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }


}
