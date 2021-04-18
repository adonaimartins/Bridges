package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.Angles;
import com.example.bridges.Model.AnglesDefects;
import com.example.bridges.Model.Bridges;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface AnglesDefectsDao {


    @Insert
    void insert(AnglesDefects anglesDefects);

    @Update
    void update(AnglesDefects anglesDefects);

    @Delete
    void delete(AnglesDefects anglesDefects);

    @Query("DELETE FROM AnglesDefects WHERE angle_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM AnglesDefects WHERE angle_id = :parentKey ORDER BY defect_id DESC")
    ListenableFuture<List<AnglesDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM AnglesDefects ORDER BY defect_id DESC")
    LiveData<List<AnglesDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM AnglesDefects")
    void deleteAll();




    @Query("SELECT * FROM AnglesDefects WHERE defect_id =:id" )
    ListenableFuture<AnglesDefects> getAnglesDefectsById(int id);



}
