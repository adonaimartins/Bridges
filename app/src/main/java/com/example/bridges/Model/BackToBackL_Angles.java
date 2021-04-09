package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BackToBackL_Angles")

public class BackToBackL_Angle {

    @PrimaryKey(autoGenerate = true)
    private int b2b_l_angle_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int stiffener_id;// INT NOT NULL, 						    /*FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)*/
    private int length_mm;
    private int height_mm;
    private int width_top_mm;
    private int width_bottom_mm;
    private int thickness_mm;
    private double length_inches;
    private double height_inches;
    private double width_top_inches;
    private double width_bottom_inches;
    private double thickness_inches;
    private String preffered_unit; // varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),

}
