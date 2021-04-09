package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Girders")

public class Girder {


    @PrimaryKey(autoGenerate = true)
    private int girder_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int deck_id; // INT NOT NULL, FOREIGN KEY (deck_id) REFERENCES Decks(deck_id),
    private String girder_name;
    private String girder_direction;
    private String elevation; //CONSTRAINT CHK_Elevation CHECK (elevation='INTERNALFACE' OR elevation='EXTERNALFACE')*/


}
