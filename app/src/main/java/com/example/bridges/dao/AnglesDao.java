package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.Angles;
import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.google.common.util.concurrent.ListenableFuture;

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

    ///in case I want to delete all the data
    @Query("DELETE FROM Angles")
    void deleteAll();

    //in case I want to select all the data
    @Query("SELECT * FROM Angles ORDER BY angle_id DESC")
    LiveData<List<Angles>> getAll();


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now




    @Query("SELECT * FROM Angles WHERE girder_id = :parentKey ORDER BY angle_id DESC")
    ListenableFuture<List<Angles>> getAllForeignKeyMatchingParentKey(int parentKey);

    ///////////////////////////////////////////////////


    @Query("SELECT * FROM Bridges WHERE bridge_id =:id" )
    ListenableFuture<Bridges> getAnbleById(int id);


/*
    @Query("SELECT * FROM Bridges WHERE sync_status = " + DatabaseContract.SYNC_STATUS_FAILED + " ORDER BY bridge_id DESC")
    ListenableFuture<List<Bridges>> getAllNonSyncBridges();
*/
}
