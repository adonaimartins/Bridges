package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AnglesRivets")
public class AngleRivet {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int angle_id;// INT NOT NULL,					    FOREIGN KEY (angle_id) REFERENCES Angles(angle_id)
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;

    /*
					);*/


}