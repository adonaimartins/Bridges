package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "L_AnglesRivetsDefects")

public class L_AngleRivetDefect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int rivet_id; // INT NOT NULL,FOREIGN KEY (rivet_id) REFERENCES L_AnglesRivets(rivet_id)
    private String type;
    private double percentegeLoss;
    private int numberAfected;

}
