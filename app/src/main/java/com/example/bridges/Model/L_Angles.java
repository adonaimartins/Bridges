package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "L_Angles", foreignKeys = @ForeignKey(entity = Stiffener.class,
        parentColumns = "stiffener_id",
        childColumns = "stiffener_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"stiffener_id"}, unique = true)}
        )

public class L_Angles {


    @PrimaryKey(autoGenerate = true)
    private int l_angle_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int stiffener_id; // INT NOT NULL, FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)
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
    private int sync_status;

    public L_Angles(int stiffener_id, int length_mm, int height_mm, int width_top_mm, int width_bottom_mm, int thickness_mm, double length_inches, double height_inches, double width_top_inches, double width_bottom_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.stiffener_id = stiffener_id;
        this.length_mm = length_mm;
        this.height_mm = height_mm;
        this.width_top_mm = width_top_mm;
        this.width_bottom_mm = width_bottom_mm;
        this.thickness_mm = thickness_mm;
        this.length_inches = length_inches;
        this.height_inches = height_inches;
        this.width_top_inches = width_top_inches;
        this.width_bottom_inches = width_bottom_inches;
        this.thickness_inches = thickness_inches;
        this.preffered_unit = preffered_unit;
        this.sync_status = sync_status;
    }

    public int getL_angle_id() {
        return l_angle_id;
    }

    public int getStiffener_id() {
        return stiffener_id;
    }

    public int getLength_mm() {
        return length_mm;
    }

    public int getHeight_mm() {
        return height_mm;
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

    public double getLength_inches() {
        return length_inches;
    }

    public double getHeight_inches() {
        return height_inches;
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

    public void setL_angle_id(int l_angle_id) {
        this.l_angle_id = l_angle_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
