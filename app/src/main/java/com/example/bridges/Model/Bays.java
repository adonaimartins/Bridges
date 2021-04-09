package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Bays")

public class Bay {

    @PrimaryKey(autoGenerate = true)
    private int bay_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int girder_id; // INT NOT NULL, //FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)
    private String bay_position;
    private int length_mm;
    private int thickness_mm;
    private double length_inches;
    private double thickness_inches;
    private String preffered_unit; // varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),

}
