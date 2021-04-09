package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "CP_RivetsDefects", foreignKeys = @ForeignKey(entity = CP_Rivets.class,
        parentColumns = "rivet_id",
        childColumns = "rivet_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"rivet_id"}, unique = true)}
        )

public class CP_RivetsDefects {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int rivet_id; //NOT NULL,FOREIGN KEY (rivet_id) REFERENCES CP_Rivets(rivet_id)
    private String type;
    private double percentegeLoss;
    private int position_L;
    private int numberAfected;
    private int sync_status;

    public CP_RivetsDefects(int rivet_id, String type, double percentegeLoss, int position_L, int numberAfected, int sync_status) {
        this.rivet_id = rivet_id;
        this.type = type;
        this.percentegeLoss = percentegeLoss;
        this.position_L = position_L;
        this.numberAfected = numberAfected;
        this.sync_status = sync_status;
    }

    public int getDefect_id() {
        return defect_id;
    }

    public int getRivet_id() {
        return rivet_id;
    }

    public String getType() {
        return type;
    }

    public double getPercentegeLoss() {
        return percentegeLoss;
    }

    public int getPosition_L() {
        return position_L;
    }

    public int getNumberAfected() {
        return numberAfected;
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
