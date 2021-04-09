package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "StiffenerRivets", foreignKeys = @ForeignKey(entity = Stiffener.class,
        parentColumns = "stiffener_id",
        childColumns = "stiffener_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
            @Index(value = {"stiffener_id"}, unique = true)}
        )

public class StiffenerRivets {

    @PrimaryKey(autoGenerate = true)
    private int rivet_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int stiffener_id; // INT NOT NULL,FOREIGN KEY (stiffener_id) REFERENCES Stiffener(stiffener_id)
    private String type;
    private int headSize;
    private int longitudinalSpacing1;
    private int transverseSpacing1;
    private int numberOfRivets;
    private int sync_status;

    public StiffenerRivets(int stiffener_id, String type, int headSize, int longitudinalSpacing1, int transverseSpacing1, int numberOfRivets, int sync_status) {
        this.stiffener_id = stiffener_id;
        this.type = type;
        this.headSize = headSize;
        this.longitudinalSpacing1 = longitudinalSpacing1;
        this.transverseSpacing1 = transverseSpacing1;
        this.numberOfRivets = numberOfRivets;
        this.sync_status = sync_status;
    }

    public int getRivet_id() {
        return rivet_id;
    }

    public int getStiffener_id() {
        return stiffener_id;
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
