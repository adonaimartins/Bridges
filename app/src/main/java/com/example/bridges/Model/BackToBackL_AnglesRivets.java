package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "BackToBackL_AnglesRivets", foreignKeys = @ForeignKey(entity = BackToBackL_Angles.class,
        parentColumns = "b2b_l_angle_id",
        childColumns = "b2b_l_angle_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"b2b_l_angle_id"}, unique = true)}
        )

public class BackToBackL_AnglesRivets {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int b2b_l_angle_id;// INT NOT NULL, /*FOREIGN KEY (b2b_l_angle_id) REFERENCES BackToBackL_Angles(b2b_l_angle_id)*/
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;
    private int sync_status;

    public BackToBackL_AnglesRivets(int b2b_l_angle_id, String type, int headSize, int longitudinalSpacing1, int transverseSpacing1, int transverseSpacing2, int numberOfRivets, int sync_status) {
        this.b2b_l_angle_id = b2b_l_angle_id;
        this.type = type;
        this.headSize = headSize;
        this.longitudinalSpacing1 = longitudinalSpacing1;
        this.transverseSpacing1 = transverseSpacing1;
        this.transverseSpacing2 = transverseSpacing2;
        this.numberOfRivets = numberOfRivets;
        this.sync_status = sync_status;
    }


    public int getRivet_id() {
        return rivet_id;
    }

    public int getB2b_l_angle_id() {
        return b2b_l_angle_id;
    }

    public String getType() {
        return type;
    }

    public int getHeadSize() {
        return headSize;
    }

    public int getLongitudinalSpacing1() {
        return longitudinalSpacing1;
    }

    public int getTransverseSpacing1() {
        return transverseSpacing1;
    }

    public int getTransverseSpacing2() {
        return transverseSpacing2;
    }

    public int getNumberOfRivets() {
        return numberOfRivets;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setRivet_id(int rivet_id) {
        this.rivet_id = rivet_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
