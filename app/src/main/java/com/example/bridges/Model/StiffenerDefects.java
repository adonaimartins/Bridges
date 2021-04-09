package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stiffenerDefects")

public class stiffenerDefect {


    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int stiffener_id; // INT NOT NULL, FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)*/
    private int defectType;
    private String leg;
    private String measurementFrom;
    private int startLength_mm;
    private int endLength_mm;
    private int width_mm;
    private int depth_mm;

}
