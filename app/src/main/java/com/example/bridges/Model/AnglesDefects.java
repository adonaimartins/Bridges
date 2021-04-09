package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AnglesDefects")
public class AngleDefect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int angle_id;// INT NOT NULL, //FOREIGN KEY (angle_id) REFERENCES Angles(angle_id)
    private String type;
    private String leg;
    private String position;
    private String elevation;
    private int startLength;
    private int endLength;
    private int length;
    private int startHeightWidth;
    private int height;
    private int width;
    private int depth;



}
