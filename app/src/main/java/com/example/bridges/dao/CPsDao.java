package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.CPs;

import java.util.List;

@Dao
public interface CPsDao {

    @Insert
    void insert(CPs cp);

    @Update
    void update(CPs cp);

    @Delete
    void delete(CPs cp);

    @Query("DELETE FROM CPs WHERE girder_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM CPs WHERE girder_id = :parentKey ORDER BY cp_id DESC")
    LiveData<List<CPs>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM CPs ORDER BY cp_id DESC")
    LiveData<List<CPs>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM CPs")
    void deleteAll();

}
