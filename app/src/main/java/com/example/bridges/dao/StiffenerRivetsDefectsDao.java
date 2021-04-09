package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.StiffenerRivetsDefects;

import java.util.List;

@Dao
public interface StiffenerRivetsDefectsDao {

    @Insert
    void insert(StiffenerRivetsDefects stiffenerRivetsDefects);

    @Update
    void update(StiffenerRivetsDefects stiffenerRivetsDefects);

    @Delete
    void delete(StiffenerRivetsDefects stiffenerRivetsDefects);

    @Query("DELETE FROM StiffenerRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM StiffenerRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<StiffenerRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM StiffenerRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<StiffenerRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM StiffenerRivetsDefects")
    void deleteAll();


}
