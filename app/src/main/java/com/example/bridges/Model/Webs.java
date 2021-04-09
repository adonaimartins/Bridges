package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Webs", foreignKeys = @ForeignKey(entity = Girders.class,
        parentColumns = "girder_id",
        childColumns = "girder_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"girder_id"}, unique = true)}
        )

public class Webs {


    @PrimaryKey(autoGenerate = true)
    private int web_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int girder_id; // INT NOT NULL, FOREIGN KEY (girder_id) REFERENCES Girders(girder_id)
    private int length_mm;
    private int height_mm;
    private int width_mm;
    private int thickness_mm;
    private double length_inches;
    private double height_inches;
    private double width_inches;
    private double thickness_inches;
    private String preffered_unit; // varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
    private int sync_status;

    public Webs(int girder_id, int length_mm, int height_mm, int width_mm, int thickness_mm, double length_inches, double height_inches, double width_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.girder_id = girder_id;
        this.length_mm = length_mm;
        this.height_mm = height_mm;
        this.width_mm = width_mm;
        this.thickness_mm = thickness_mm;
        this.length_inches = length_inches;
        this.height_inches = height_inches;
        this.width_inches = width_inches;
        this.thickness_inches = thickness_inches;
        this.preffered_unit = preffered_unit;
        this.sync_status = sync_status;
    }

    public int getWeb_id() {
        return web_id;
    }

    public int getGirder_id() {
        return girder_id;
    }

    public int getLength_mm() {
        return length_mm;
    }

    public int getHeight_mm() {
        return height_mm;
    }

    public int getWidth_mm() {
        return width_mm;
    }

    public int getThickness_mm() {
        return thickness_mm;
    }

    public double getLength_inches() {
        return length_inches;
    }

    public double getHeight_inches() {
        return height_inches;
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

    public void setWeb_id(int web_id) {
        this.web_id = web_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
