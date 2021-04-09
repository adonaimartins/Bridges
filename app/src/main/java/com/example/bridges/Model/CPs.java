package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CPs")

public class CP {


    @PrimaryKey(autoGenerate = true)
    private int cp_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int girder_id; // INT NOT NULL, ///*FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)*/
    private String position; // varchar(255) CHECK (position='TOP' OR position='BOTTOM'),
    private int location;
    private int stiffener_start;
    private int start_distance_mm;
    private double start_distance_inches;
    private int stiffener_end;
    private int end_distance_mm;
    private double end_distance_inches;
    private int width_mm;
    private int thickness_mm;
    private double width_inches;
    private double thickness_inches;
    private String preffered_unit;// varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),

}
