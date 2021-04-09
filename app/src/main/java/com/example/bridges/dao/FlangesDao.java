package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.Flanges;

import java.util.List;

@Dao
public interface FlangesDao {

    @Insert
    void insert(Flanges flanges);

    @Update
    void update(Flanges flanges);

    @Delete
    void delete(Flanges flanges);

    @Query("DELETE FROM Flanges WHERE girder_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Flanges WHERE girder_id = :parentKey ORDER BY flange_id DESC")
    LiveData<List<Flanges>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Flanges ORDER BY flange_id DESC")
    LiveData<List<Flanges>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Flanges")
    void deleteAll();

}
