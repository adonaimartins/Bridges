package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BackToBackL_AnglesRivetsDefects")

public class BackToBackL_AngleRivetDefect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int rivet_id;// INT NOT NULL, /*/FOREIGN KEY (rivet_id) REFERENCES BackToBackL_AnglesRivets(rivet_id)*/
    private String  varchar;
    private double percentegeLoss;
    private int numberAfected;

}
