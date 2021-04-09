package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Bays", foreignKeys = @ForeignKey(entity = Girders.class,
        parentColumns = "girder_id",
        childColumns = "girder_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"girder_id"}, unique = true)}
        )

public class Bays {

    @PrimaryKey(autoGenerate = true)
    private int bay_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int girder_id; // INT NOT NULL, //FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)
    private String bay_position;
    private int length_mm;
    private int thickness_mm;
    private double length_inches;
    private double thickness_inches;
    private String preffered_unit; // varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
    private int sync_status;


    public Bays(int girder_id, String bay_position, int length_mm, int thickness_mm, double length_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.girder_id = girder_id;
        this.bay_position = bay_position;
        this.length_mm = length_mm;
        this.thickness_mm = thickness_mm;
        this.length_inches = length_inches;
        this.thickness_inches = thickness_inches;
        this.preffered_unit = preffered_unit;
        this.sync_status = sync_status;
    }

    public int getBay_id() {
        return bay_id;
    }

    public int getGirder_id() {
        return girder_id;
    }

    public String getBay_position() {
        return bay_position;
    }

    public int getLength_mm() {
        return length_mm;
    }

    public int getThickness_mm() {
        return thickness_mm;
    }

    public double getLength_inches() {
        return length_inches;
    }

    public double getThickness_inches() {
        return thickness_inches;
    }

    public String getPreffered_unit() {
        return preffered_unit;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setBay_id(int bay_id) {
        this.bay_id = bay_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
