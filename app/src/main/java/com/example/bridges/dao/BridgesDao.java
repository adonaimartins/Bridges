package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.Bridges;

import java.util.List;

@Dao
public interface BridgesDao {

    @Insert
    void insert(Bridges bridge);

    @Update
    void update(Bridges bridge);

    @Delete
    void delete(Bridges bridge);

    @Query("DELETE FROM Bridges")
    void deleteAllBridges();

    @Query("SELECT * FROM Bridges ORDER BY structure_name DESC")
    LiveData<List<Bridges>> getAllBridges();

}
