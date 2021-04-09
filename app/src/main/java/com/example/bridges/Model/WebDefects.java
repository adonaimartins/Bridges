package com.example.bridges.Model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "WebDefects", foreignKeys = @ForeignKey(entity = Webs.class,
        parentColumns = "web_id",
        childColumns = "web_id",
        onDelete = ForeignKey.CASCADE),
        indices = {
                @Index(value = {"web_id"}, unique = true)}
        )

public class WebDefects {


    @PrimaryKey(autoGenerate = true)
    private int defect_id; //INT AUTO_INCREMENT PRIMARY KEY


    private int web_id; // INT NOT NULL,FOREIGN KEY (web_id) REFERENCES Webs(web_id)
    private String type;
    private int startLength;
    private int endLength;
    private int startHeight;
    private int endHeight;
    private int length;
    private int height;
    private int sync_status;

    public WebDefects(int web_id, String type, int startLength, int endLength, int startHeight, int endHeight, int length, int height, int sync_status) {
        this.web_id = web_id;
        this.type = type;
        this.startLength = startLength;
        this.endLength = endLength;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.length = length;
        this.height = height;
        this.sync_status = sync_status;
    }

    public int getDefect_id() {
        return defect_id;
    }

    public int getWeb_id() {
        return web_id;
    }

    public String getType() {
        return type;
    }

    public int getStartLength() {
        return startLength;
    }

    public int getEndLength() {
        return endLength;
    }

    public int getStartHeight() {
        return startHeight;
    }

    public int getEndHeight() {
        return endHeight;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
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
