package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GussetPlatesRivets")

public class GussetPlateRivet {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int gusset_plate_id; // INT NOT NULL,//FOREIGN KEY (gusset_plate_id) REFERENCES GussetPlates(gusset_plate_id)
    private String type;
    private int headSize ;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;

}
