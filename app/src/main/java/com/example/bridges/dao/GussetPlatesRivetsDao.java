package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.GussetPlatesRivets;

import java.util.List;

@Dao
public interface GussetPlatesRivetsDao {




    @Insert
    void insert(GussetPlatesRivets gussetPlatesRivets);

    @Update
    void update(GussetPlatesRivets gussetPlatesRivets);

    @Delete
    void delete(GussetPlatesRivets gussetPlatesRivets);

    @Query("DELETE FROM GussetPlatesRivets WHERE gusset_plate_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM GussetPlatesRivets WHERE gusset_plate_id = :parentKey ORDER BY rivet_id DESC")
    LiveData<List<GussetPlatesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM GussetPlatesRivets ORDER BY rivet_id DESC")
    LiveData<List<GussetPlatesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM GussetPlatesRivets")
    void deleteAll();

}
