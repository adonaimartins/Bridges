package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.FlangesRivetsDefects;

import java.util.List;

@Dao
public interface FlangesRivetsDefectsDao {



    @Insert
    void insert(FlangesRivetsDefects flangesRivetsDefects);

    @Update
    void update(FlangesRivetsDefects flangesRivetsDefects);

    @Delete
    void delete(FlangesRivetsDefects flangesRivetsDefects);

    @Query("DELETE FROM FlangesRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM FlangesRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<FlangesRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM FlangesRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<FlangesRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM FlangesRivetsDefects")
    void deleteAll();
}
