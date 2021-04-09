package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CP_Rivets")

public class CP_Rivet {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int cp_id;// INT NOT NULL,FOREIGN KEY (cp_id) REFERENCES CPs(cp_id)
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;


}
