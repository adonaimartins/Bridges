package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "GussetPlatesRivets", foreignKeys = @ForeignKey(entity = GussetPlates.class,
        parentColumns = "gusset_plate_id",
        childColumns = "gusset_plate_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
            @Index(value = {"gusset_plate_id"}, unique = true)}
        )

public class GussetPlatesRivets {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int gusset_plate_id; // INT NOT NULL,//FOREIGN KEY (gusset_plate_id) REFERENCES GussetPlates(gusset_plate_id)
    private String type;
    private int headSize ;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int transverseSpacing2;
    private int numberOfRivets;
    private int sync_status;

    public GussetPlatesRivets(int gusset_plate_id, String type, int headSize, int longitudinalSpacing1, int transverseSpacing1, int transverseSpacing2, int numberOfRivets, int sync_status) {
        this.gusset_plate_id = gusset_plate_id;
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

    public int getGusset_plate_id() {
        return gusset_plate_id;
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
