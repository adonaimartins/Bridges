package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.WebDefects;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface WebDefectsDao {

    @Insert
    void insert(WebDefects webDefects);

    @Update
    void update(WebDefects webDefects);

    @Delete
    void delete(WebDefects webDefects);

    @Query("DELETE FROM WebDefects WHERE web_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM WebDefects WHERE web_id = :parentKey ORDER BY defect_id DESC")
    ListenableFuture<List<WebDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM WebDefects ORDER BY defect_id DESC")
    LiveData<List<WebDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM WebDefects")
    void deleteAll();

    @Query("SELECT * FROM WebDefects WHERE defect_id =:id" )
    ListenableFuture<WebDefects> getWebDefectsById(int id);


}
