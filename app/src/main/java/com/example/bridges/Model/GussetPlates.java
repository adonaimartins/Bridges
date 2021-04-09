package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "GussetPlates", foreignKeys = @ForeignKey(entity = Stiffener.class,
        parentColumns = "stiffener_id",
        childColumns = "stiffener_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"stiffener_id"}, unique = true)}
        )

public class GussetPlates {


    @PrimaryKey(autoGenerate = true)
    private int gusset_plate_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int stiffener_id; // NOT NULL, FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)


    private int width_top_mm;
    private int width_bottom_mm;
    private int thickness_mm;

    private double width_top_inches;
    private double width_bottom_inches;
    private double thickness_inches;
    private String preffered_unit; //CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
    private int sync_status;

    public GussetPlates(int stiffener_id, int width_top_mm, int width_bottom_mm, int thickness_mm, double width_top_inches, double width_bottom_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.stiffener_id = stiffener_id;
        this.width_top_mm = width_top_mm;
        this.width_bottom_mm = width_bottom_mm;
        this.thickness_mm = thickness_mm;
        this.width_top_inches = width_top_inches;
        this.width_bottom_inches = width_bottom_inches;
        this.thickness_inches = thickness_inches;
        this.preffered_unit = preffered_unit;
        this.sync_status = sync_status;
    }

    public int getGusset_plate_id() {
        return gusset_plate_id;
    }

    public int getStiffener_id() {
        return stiffener_id;
    }

    public int getWidth_top_mm() {
        return width_top_mm;
    }

    public int getWidth_bottom_mm() {
        return width_bottom_mm;
    }

    public int getThickness_mm() {
        return thickness_mm;
    }

    public double getWidth_top_inches() {
        return width_top_inches;
    }

    public double getWidth_bottom_inches() {
        return width_bottom_inches;
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

    public void setGusset_plate_id(int gusset_plate_id) {
        this.gusset_plate_id = gusset_plate_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
