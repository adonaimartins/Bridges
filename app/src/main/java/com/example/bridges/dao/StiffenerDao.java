package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.Stiffener;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface StiffenerDao {

    @Insert
    void insert(Stiffener stiffener);

    @Update
    void update(Stiffener stiffener);

    @Delete
    void delete(Stiffener stiffener);

    @Query("DELETE FROM Stiffener WHERE bay_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Stiffener WHERE bay_id = :parentKey ORDER BY stiffener_id DESC")
    ListenableFuture<List<Stiffener>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Stiffener ORDER BY stiffener_id DESC")
    LiveData<List<Stiffener>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Stiffener")
    void deleteAll();

    @Query("SELECT * FROM Stiffener WHERE stiffener_id =:id" )
    ListenableFuture<Stiffener> getStiffenerById(int id);

}
