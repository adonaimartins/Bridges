package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.Angles;

import java.util.List;

@Dao
public interface AnglesDao {


    @Insert
    void insert(Angles angle);

    @Update
    void update(Angles angle);

    @Delete
    void delete(Angles angle);

    @Query("DELETE FROM Angles WHERE girder_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Angles WHERE girder_id = :parentKey ORDER BY angle_id DESC")
    LiveData<List<Angles>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Angles ORDER BY angle_id DESC")
    LiveData<List<Angles>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Angles")
    void deleteAll();

}
