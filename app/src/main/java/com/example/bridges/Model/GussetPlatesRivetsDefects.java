package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GussetPlatesRivetsDefects")

public class GussetPlateRivetDefect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int rivet_id; // INT NOT NULL,FOREIGN KEY (rivet_id) REFERENCES GussetPlatesRivets(rivet_id)
    private String type;
    private double percentegeLoss;
    private int numberAfected;
}
