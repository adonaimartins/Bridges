package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StiffenerRivets")

public class StiffenerRivet {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int stiffener_id; // INT NOT NULL,FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int numberOfRivets;

}
