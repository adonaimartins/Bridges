package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "StiffenerDefects", foreignKeys = @ForeignKey(entity = Stiffener.class,
        parentColumns = "stiffener_id",
        childColumns = "stiffener_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"stiffener_id"}, unique = true)}
        )

public class StiffenerDefects {


    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int stiffener_id; // INT NOT NULL, FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)*/
    private int defectType;
    private String leg;
    private String measurementFrom;
    private int startLength_mm;
    private int endLength_mm;
    private int width_mm;
    private int depth_mm;
    private int sync_status;

    public StiffenerDefects(int stiffener_id, int defectType, String leg, String measurementFrom, int startLength_mm, int endLength_mm, int width_mm, int depth_mm, int sync_status) {
        this.stiffener_id = stiffener_id;
        this.defectType = defectType;
        this.leg = leg;
        this.measurementFrom = measurementFrom;
        this.startLength_mm = startLength_mm;
        this.endLength_mm = endLength_mm;
        this.width_mm = width_mm;
        this.depth_mm = depth_mm;
        this.sync_status = sync_status;
    }

    public int getDefect_id() {
        return defect_id;
    }

    public int getStiffener_id() {
        return stiffener_id;
    }

    public int getDefectType() {
        return defectType;
    }

    public String getLeg() {
        return leg;
    }

    public String getMeasurementFrom() {
        return measurementFrom;
    }

    public int getStartLength_mm() {
        return startLength_mm;
    }

    public int getEndLength_mm() {
        return endLength_mm;
    }

    public int getWidth_mm() {
        return width_mm;
    }

    public int getDepth_mm() {
        return depth_mm;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setDefect_id(int defect_id) {
        this.defect_id = defect_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
