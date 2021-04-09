package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.GussetPlates;

import java.util.List;

@Dao
public interface GussetPlatesDao {



    @Insert
    void insert(GussetPlates gussetPlates);

    @Update
    void update(GussetPlates gussetPlates);

    @Delete
    void delete(GussetPlates gussetPlates);

    @Query("DELETE FROM GussetPlates WHERE stiffener_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM GussetPlates WHERE stiffener_id = :parentKey ORDER BY gusset_plate_id DESC")
    LiveData<List<GussetPlates>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM GussetPlates ORDER BY gusset_plate_id DESC")
    LiveData<List<GussetPlates>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM GussetPlates")
    void deleteAll();

}
