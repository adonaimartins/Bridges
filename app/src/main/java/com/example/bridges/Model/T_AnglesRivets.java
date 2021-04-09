package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "T_AnglesRivets")

public class T_AngleRivet {


    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int t_angle_id; // INT NOT NULL, FOREIGN KEY (t_angle_id) REFERENCES T_Angles(t_angle_id)*/
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;

}
