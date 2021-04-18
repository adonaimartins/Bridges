package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivets;
import com.example.bridges.Model.AnglesRivetsDefects;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface AnglesRivetsDefectsDao {

    @Insert
    void insert(AnglesRivetsDefects anglesRivetsDefects);

    @Update
    void update(AnglesRivetsDefects anglesRivetsDefects);

    @Delete
    void delete(AnglesRivetsDefects anglesRivetsDefects);

    @Query("DELETE FROM AnglesRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM AnglesRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    ListenableFuture<List<AnglesRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM AnglesRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<AnglesRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM AnglesRivetsDefects")
    void deleteAll();


    @Query("SELECT * FROM AnglesRivetsDefects WHERE defect_id =:id" )
    ListenableFuture<AnglesRivetsDefects> getAnglesRivetsDefectsById(int id);

}
