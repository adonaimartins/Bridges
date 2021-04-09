package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Girders", foreignKeys = @ForeignKey(entity = Decks.class,
        parentColumns = "deck_id",
        childColumns = "deck_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"deck_id"}, unique = true)}
        )

public class Girders {


    @PrimaryKey(autoGenerate = true)
    private int girder_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int deck_id; // INT NOT NULL, FOREIGN KEY (deck_id) REFERENCES Decks(deck_id),
    private String girder_name;
    private String girder_direction;
    private String elevation; //CONSTRAINT CHK_Elevation CHECK (elevation='INTERNALFACE' OR elevation='EXTERNALFACE')*/
    private int sync_status;


    public Girders(int deck_id, String girder_name, String girder_direction, String elevation, int sync_status) {
        this.deck_id = deck_id;
        this.girder_name = girder_name;
        this.girder_direction = girder_direction;
        this.elevation = elevation;
        this.sync_status = sync_status;
    }

    public int getGirder_id() {
        return girder_id;
    }

    public int getDeck_id() {
        return deck_id;
    }

    public String getGirder_name() {
        return girder_name;
    }

    public String getGirder_direction() {
        return girder_direction;
    }

    public String getElevation() {
        return elevation;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setGirder_id(int girder_id) {
        this.girder_id = girder_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
