package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FlangeDefects")

public class FlangeDefect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int flange_id; // INT NOT NULL,FOREIGN KEY (flange_id) REFERENCES Flanges(flange_id)
    private String type;
    private String position;
    private String optionChosed;
    private int startLength;
    private int endLength;
    private int length;
    private int startWidth;
    private int endWidth;
    private int width;
    private int depth;


}
