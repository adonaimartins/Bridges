package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivets;

import java.util.List;

@Dao
public interface AnglesRivetsDao {

    @Insert
    void insert(AnglesRivets anglesRivets);

    @Update
    void update(AnglesRivets anglesRivets);

    @Delete
    void delete(AnglesRivets anglesRivets);

    @Query("DELETE FROM AnglesRivets WHERE angle_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM AnglesRivets WHERE angle_id = :parentKey ORDER BY rivet_id DESC")
    LiveData<List<AnglesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM AnglesRivets ORDER BY rivet_id DESC")
    LiveData<List<AnglesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM AnglesRivets")
    void deleteAll();


}
