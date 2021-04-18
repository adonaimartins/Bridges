package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BridgesDao {

    @Insert
    void insert(Bridges bridge);

    @Update
    void update(Bridges bridge);

    @Delete
    void delete(Bridges bridge);

    @Query("SELECT * FROM Bridges WHERE bridge_id =:id" )
    ListenableFuture<Bridges> getBridgeById(int id);

    @Query("DELETE FROM Bridges")
    void deleteAllBridges();

    @Query("SELECT * FROM Bridges ORDER BY bridge_id DESC")
    LiveData<List<Bridges>> getAllBridges();


    @Query("SELECT * FROM Bridges WHERE sync_status = " + DatabaseContract.SYNC_STATUS_FAILED + " ORDER BY bridge_id DESC")
    ListenableFuture<List<Bridges>> getAllNonSyncBridges();
}
