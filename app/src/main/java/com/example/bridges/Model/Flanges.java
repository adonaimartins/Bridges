package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Flanges", foreignKeys = @ForeignKey(entity = Girders.class,
        parentColumns = "girder_id",
        childColumns = "girder_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"girder_id"}, unique = true)}
        )

public class Flanges {

    @PrimaryKey(autoGenerate = true)
    private int flange_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int girder_id;// INT NOT NULL, FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)
    private String position;// varchar(255) CHECK (position='TOP' OR position='BOTTOM'),
    private int width_mm;
    private int thickness_mm;
    private double width_inches;
    private double thickness_inches;
    private String preffered_unit;// varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
    private int sync_status;

    public Flanges(int girder_id, String position, int width_mm, int thickness_mm, double width_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.girder_id = girder_id;
        this.position = position;
        this.width_mm = width_mm;
        this.thickness_mm = thickness_mm;
        this.width_inches = width_inches;
        this.thickness_inches = thickness_inches;
        this.preffered_unit = preffered_unit;
        this.sync_status = sync_status;


    }

    public int getFlange_id() {
        return flange_id;
    }

    public int getGirder_id() {
        return girder_id;
    }

    public String getPosition() {
        return position;
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

    public void setFlange_id(int flange_id) {
        this.flange_id = flange_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
