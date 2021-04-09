package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "GussetPlates")

public class GussetPlate {


    @PrimaryKey(autoGenerate = true)
    private int gusset_plate_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int stiffener_id; // NOT NULL, FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)


    private int width_top_mm;
    private int width_bottom_mm;
    private int thickness_mm;

    private double width_top_inches;
    private double width_bottom_inches;
    private double thickness_inches;
    private String preffered_unit; //CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),

}
