package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CP_RivetsDefects")

public class CP_RivetDefect {

    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY
    private int rivet_id; //NOT NULL,FOREIGN KEY (rivet_id) REFERENCES CP_Rivets(rivet_id)
    private String type;
    private double percentegeLoss;
    private int position_L;
    private int numberAfected;
}
