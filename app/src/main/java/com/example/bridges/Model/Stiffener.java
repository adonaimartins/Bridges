package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Stiffener", foreignKeys = @ForeignKey(entity = Bays.class,
        parentColumns = "bay_id",
        childColumns = "bay_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"bay_id"}, unique = true)}
        )

public class Stiffener {


    @PrimaryKey(autoGenerate = true)

    private int stiffener_id; // INT AUTO_INCREMENT PRIMARY KEY,


    private int bay_id; // INT NOT NULL, FOREIGN KEY (bay_id) REFERENCES Bays(bay_id)
    private int stiffener_number;
    private int type;
    private int sync_status;

    public Stiffener(int bay_id, int stiffener_number, int type, int sync_status) {
        this.bay_id = bay_id;
        this.stiffener_number = stiffener_number;
        this.type = type;
        this.sync_status = sync_status;
    }

    public int getStiffener_id() {
        return stiffener_id;
    }

    public int getBay_id() {
        return bay_id;
    }

    public int getStiffener_number() {
        return stiffener_number;
    }

    public int getType() {
        return type;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setStiffener_id(int stiffener_id) {
        this.stiffener_id = stiffener_id;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }
}
