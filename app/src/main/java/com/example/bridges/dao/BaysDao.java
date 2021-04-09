package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.Bays;

import java.util.List;

@Dao
public interface BaysDao {

    @Insert
    void insert(Bays bay);

    @Update
    void update(Bays bay);

    @Delete
    void delete(Bays bay);

    @Query("DELETE FROM Bays WHERE girder_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Bays WHERE girder_id = :parentKey ORDER BY bay_id DESC")
    LiveData<List<Bays>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Bays ORDER BY bay_id DESC")
    LiveData<List<Bays>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Bays")
    void deleteAll();
}
