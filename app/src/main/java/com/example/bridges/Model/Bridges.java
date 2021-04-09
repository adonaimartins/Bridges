package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Bridges")
public class Bridge {


    @PrimaryKey(autoGenerate = true)
    private int bridge_id; //INT AUTO_INCREMENT PRIMARY KEY


    private String surveyor_name; // varchar(255) NOT NULL,
    private String surveyor_lastName; // varchar(255)
    private String structure_name; // varchar(255) NOT NULL,
    private String structure_location; // varchar(255) NOT NULL,
    private String structure_number; // varchar(255) NOT NULL,
    private int mileageMiles; // INT,
    private int mileageYards; // INT
    private int Sync_status;

    //@Ignore in case I want to add a property to ignore

    public Bridge(String surveyor_name, String surveyor_lastName, String structure_name, String structure_location, String structure_number, int mileageMiles, int mileageYards) {
        this.surveyor_name = surveyor_name;
        this.surveyor_lastName = surveyor_lastName;
        this.structure_name = structure_name;
        this.structure_location = structure_location;
        this.structure_number = structure_number;
        this.mileageMiles = mileageMiles;
        this.mileageYards = mileageYards;
    }

    public void setBridge_id(int bridge_id) {
        this.bridge_id = bridge_id;
    }

    public int getBridge_id() {
        return bridge_id;
    }

    public String getSurveyor_name() {
        return surveyor_name;
    }

    public String getSurveyor_lastName() {
        return surveyor_lastName;
    }

    public String getStructure_name() {
        return structure_name;
    }

    public String getStructure_location() {
        return structure_location;
    }

    public String getStructure_number() {
        return structure_number;
    }

    public int getMileageMiles() {
        return mileageMiles;
    }

    public int getMileageYards() {
        return mileageYards;
    }
}
