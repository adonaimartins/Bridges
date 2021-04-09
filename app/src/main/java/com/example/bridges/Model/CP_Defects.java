package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "CP_Defects", foreignKeys = @ForeignKey(entity = CPs.class,
        parentColumns = "cp_id",
        childColumns = "cp_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"cp_id"}, unique = true)
        }
)

public class CP_Defects {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int cp_id; //INT NOT NULL,FOREIGN KEY (cp_id) REFERENCES CPs(cp_id)
    private String type;
    private String elevation;
    private String optionChosed;
    private int startLength;
    private int endLength;
    private int length;
    private int startWidth;
    private int endWidth;
    private int width;
    private int depth;
    private int sync_status;


    public CP_Defects(int cp_id, String type, String elevation, String optionChosed, int startLength, int endLength, int length, int startWidth, int endWidth, int width, int depth, int sync_status) {
        this.cp_id = cp_id;
        this.type = type;
        this.elevation = elevation;
        this.optionChosed = optionChosed;
        this.startLength = startLength;
        this.endLength = endLength;
        this.length = length;
        this.startWidth = startWidth;
        this.endWidth = endWidth;
        this.width = width;
        this.depth = depth;
        this.sync_status = sync_status;
    }

    public int getDefect_id() {
        return defect_id;
    }

    public int getCp_id() {
        return cp_id;
    }

    public String getType() {
        return type;
    }

    public String getElevation() {
        return elevation;
    }

    public String getOptionChosed() {
        return optionChosed;
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

    public int getStartWidth() {
        return startWidth;
    }

    public int getEndWidth() {
        return endWidth;
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
