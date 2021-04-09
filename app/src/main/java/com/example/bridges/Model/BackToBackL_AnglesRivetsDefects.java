package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "BackToBackL_AnglesRivetsDefects", foreignKeys = @ForeignKey(entity = BackToBackL_AnglesRivets.class,
        parentColumns = "rivet_id",
        childColumns = "rivet_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"rivet_id"}, unique = true)}
        )

public class BackToBackL_AnglesRivetsDefects {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int rivet_id;// INT NOT NULL, /*/FOREIGN KEY (rivet_id) REFERENCES BackToBackL_AnglesRivets(rivet_id)*/
    private String  varchar;
    private double percentegeLoss;
    private int numberAfected;
    private int sync_status;

    public BackToBackL_AnglesRivetsDefects(int rivet_id, String varchar, double percentegeLoss, int numberAfected, int sync_status) {
        this.rivet_id = rivet_id;
        this.varchar = varchar;
        this.percentegeLoss = percentegeLoss;
        this.numberAfected = numberAfected;
        this.sync_status = sync_status;
    }

    public int getDefect_id() {
        return defect_id;
    }

    public int getRivet_id() {
        return rivet_id;
    }

    public String getVarchar() {
        return varchar;
    }

    public double getPercentegeLoss() {
        return percentegeLoss;
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
