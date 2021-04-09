package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "Angles")

public class Angle {

    @PrimaryKey(autoGenerate = true)
    private int angle_id; //INT AUTO_INCREMENT PRIMARY KEY
    private ForeignKey girder_id; // varchar(255) NOT NULL, ////NED TO SORT
   // private int girder_id INT NOT NULL,
    private String position;
    private int length_mm;
    private int height_mm;
    private int width_mm;
    private int thickness_mm;
    private double length_inches;
    private double height_inches;
    private double width_inches;
    private double thickness_inches;
    private int Sync_status;
    /*
		    angle_id INT AUTO_INCREMENT PRIMARY KEY,
		    girder_id INT NOT NULL,
		    position varchar(255),
		    length_mm int,
		    height_mm int,
			width_mm int,
		    thickness_mm int,
		    length_inches double(5,2),
		    height_inches double(5,2),
			width_inches double(5,2),
		    thickness_inches double(5,2),
		    preffered_unit varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
		    FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)
		);
*/


}
