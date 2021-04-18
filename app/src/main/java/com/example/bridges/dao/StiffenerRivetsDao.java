package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.StiffenerRivets;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface StiffenerRivetsDao {

    @Insert
    void insert(StiffenerRivets stiffenerRivets);

    @Update
    void update(StiffenerRivets stiffenerRivets);

    @Delete
    void delete(StiffenerRivets stiffenerRivets);

    @Query("DELETE FROM StiffenerRivets WHERE stiffener_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM StiffenerRivets WHERE stiffener_id = :parentKey ORDER BY rivet_id DESC")
    ListenableFuture<List<StiffenerRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM StiffenerRivets ORDER BY rivet_id DESC")
    LiveData<List<StiffenerRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM StiffenerRivets")
    void deleteAll();

    @Query("SELECT * FROM StiffenerRivets WHERE rivet_id =:id" )
    ListenableFuture<StiffenerRivets> getStiffenerRivetsById(int id);

}
