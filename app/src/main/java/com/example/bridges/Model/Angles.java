package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "Angles", foreignKeys =   @ForeignKey(entity = Girders.class,
        parentColumns = "girder_id",
        childColumns = "girder_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"girder_id"}, unique = true)})
public class Angles {

    @PrimaryKey(autoGenerate = true)
    private int angle_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int girder_id;// INT NOT NULL, FOREIGN KEY (girder_id) REFERENCES Girders(girder_id) ////NEED TO SORT

    private String position;
    private int length_mm;
    private int height_mm;
    private int width_mm;
    private int thickness_mm;
    private double length_inches;
    private double height_inches;
    private double width_inches;
    private double thickness_inches;
    private String preffered_unit;// varchar(255)CHECK (preffered_unit='MM' OR preffered_unit='INCHES'),
    private int sync_status;

    public Angles(int girder_id, String position, int length_mm, int height_mm, int width_mm, int thickness_mm, double length_inches, double height_inches, double width_inches, double thickness_inches, String preffered_unit, int sync_status) {
        this.girder_id = girder_id;
        this.position = position;
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

    public int getAngle_id() {
        return angle_id;
    }

    public int getGirder_id() {
        return girder_id;
    }

    public String getPosition() {
        return position;
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

    public void setAngle_id(int angle_id) {
        this.angle_id = angle_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }

    /*
      int CASCADE — A “CASCADE” action propagates the delete or update operation on the parent key to
      each dependent child key.

      int NO_ACTION //default — When a parent key is modified or deleted from the database, no special
      action is taken.

      int RESTRICT — The RESTRICT action means that the application is prohibited from deleting (for onDelete())
      or modifying (for onUpdate()) a parent key when there exists one or more child keys mapped to it.

      int SET_DEFAULT — The “SET DEFAULT” actions are similar to SET_NULL, except that each of the
      child key columns is set to contain the columns default value instead of NULL.*/
}


