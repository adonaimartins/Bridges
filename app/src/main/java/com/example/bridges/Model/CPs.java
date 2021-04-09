package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "CPs", foreignKeys = @ForeignKey(entity = Girders.class,
        parentColumns = "girder_id",
        childColumns = "girder_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"girder_id"}, unique = true)}
        )

public class CPs {


    @PrimaryKey(autoGenerate = true)
    private int cp_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int girder_id; // INT NOT NULL, ///*FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)*/
    private String position; // varchar(255) CHECK (position='TOP' OR position='BOTTOM'),
    private int location;
    private int stiffener_start;
    private int start_distance_mm;
    private double start_distance_inches;
    private int stiffener_end;
    private int end_distance_mm;
    private double end_distance_inches;
    private int width_mm;
    private int thickness_mm;
    private double width_inches;
    private double thickness_inches;
    private String preffered_unit;// varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
    private int sync_status;

    public CPs(int girder_id, String position, int location, int stiffener_start, int start_distance_mm, double start_distance_inches, int stiffener_end, int end_distance_mm, double end_distance_inches, int width_mm, int thickness_mm, double width_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.girder_id = girder_id;
        this.position = position;
        this.location = location;
        this.stiffener_start = stiffener_start;
        this.start_distance_mm = start_distance_mm;
        this.start_distance_inches = start_distance_inches;
        this.stiffener_end = stiffener_end;
        this.end_distance_mm = end_distance_mm;
        this.end_distance_inches = end_distance_inches;
        this.width_mm = width_mm;
        this.thickness_mm = thickness_mm;
        this.width_inches = width_inches;
        this.thickness_inches = thickness_inches;
        this.preffered_unit = preffered_unit;
        this.sync_status = sync_status;
    }


    public int getCp_id() {
        return cp_id;
    }

    public int getGirder_id() {
        return girder_id;
    }

    public String getPosition() {
        return position;
    }

    public int getLocation() {
        return location;
    }

    public int getStiffener_start() {
        return stiffener_start;
    }

    public int getStart_distance_mm() {
        return start_distance_mm;
    }

    public double getStart_distance_inches() {
        return start_distance_inches;
    }

    public int getStiffener_end() {
        return stiffener_end;
    }

    public int getEnd_distance_mm() {
        return end_distance_mm;
    }

    public double getEnd_distance_inches() {
        return end_distance_inches;
    }

    public int getWidth_mm() {
        return width_mm;
    }

    public int getThickness_mm() {
        return thickness_mm;
    }

    public double getWidth_inches() {
        return width_inches;
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

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
