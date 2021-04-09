package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CP_Defects")

public class CP_Defect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY

    private int cp_id; //INT NOT NULL,FOREIGN KEY (cp_id) REFERENCES CPs(cp_id)
    private String type;
    private String elevation;
    private String optionChosed;
    private int startLength;
    private int endLength;
    private int length;
    private int startWidth;
    private int endWidth;
    private int width;
    private int depth;

}
