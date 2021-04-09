package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "WebDefects")

public class WebDefect {


    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int web_id; // INT NOT NULL,FOREIGN KEY (web_id) REFERENCES Webs(web_id)
    private String type;
    private int startLength;
    private int endLength;
    private int startHeight;
    private int endHeight;
    private int length;
    private int height;


}
