package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.GussetPlatesRivetsDefects;

import java.util.List;

@Dao
public interface GussetPlatesRivetsDefectsDao {

    @Insert
    void insert(GussetPlatesRivetsDefects gussetPlatesRivetsDefects);

    @Update
    void update(GussetPlatesRivetsDefects gussetPlatesRivetsDefects);

    @Delete
    void delete(GussetPlatesRivetsDefects gussetPlatesRivetsDefects);

    @Query("DELETE FROM GussetPlatesRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM GussetPlatesRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<GussetPlatesRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM GussetPlatesRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<GussetPlatesRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM GussetPlatesRivetsDefects")
    void deleteAll();

}
