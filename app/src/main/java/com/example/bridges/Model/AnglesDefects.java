package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "AnglesDefects", foreignKeys = @ForeignKey(entity = Angles.class,
        parentColumns = "angle_id",
        childColumns = "angle_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"angle_id"}, unique = true)})
public class AnglesDefects {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int angle_id;// INT NOT NULL, //FOREIGN KEY (angle_id) REFERENCES Angles(angle_id)
    private String type;
    private String leg;
    private String position;
    private String elevation;
    private int startLength;
    private int endLength;
    private int length;
    private int startHeightWidth;
    private int height;
    private int width;
    private int depth;
    private int sync_status;

    public AnglesDefects(int angle_id, String type, String leg, String position, String elevation, int startLength, int endLength, int length, int startHeightWidth, int height, int width, int depth, int sync_status) {
        this.angle_id = angle_id;
        this.type = type;
        this.leg = leg;
        this.position = position;
        this.elevation = elevation;
        this.startLength = startLength;
        this.endLength = endLength;
        this.length = length;
        this.startHeightWidth = startHeightWidth;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.sync_status = sync_status;
    }

    public int getDefect_id() {
        return defect_id;
    }

    public int getAngle_id() {
        return angle_id;
    }

    public String getType() {
        return type;
    }

    public String getLeg() {
        return leg;
    }

    public String getPosition() {
        return position;
    }

    public String getElevation() {
        return elevation;
    }

    public int getStartLength() {
        return startLength;
    }

    public int getEndLength() {
        return endLength;
    }

    public int getLength() {
        return length;
    }

    public int getStartHeightWidth() {
        return startHeightWidth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
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
