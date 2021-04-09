package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BackToBackL_AnglesRivets")

public class BackToBackL_AngleRivet {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int b2b_l_angle_id;// INT NOT NULL, /*FOREIGN KEY (b2b_l_angle_id) REFERENCES BackToBackL_Angles(b2b_l_angle_id)*/
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;

}
