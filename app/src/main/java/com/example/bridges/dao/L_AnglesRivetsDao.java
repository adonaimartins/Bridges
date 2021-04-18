package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.L_AnglesRivets;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface L_AnglesRivetsDao {


    @Insert
    void insert(L_AnglesRivets l_AnglesRivets);

    @Update
    void update(L_AnglesRivets l_AnglesRivets);

    @Delete
    void delete(L_AnglesRivets l_AnglesRivets);

    @Query("DELETE FROM L_AnglesRivets WHERE l_angle_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM L_AnglesRivets WHERE l_angle_id = :parentKey ORDER BY rivet_id DESC")
    ListenableFuture<List<L_AnglesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM L_AnglesRivets ORDER BY rivet_id DESC")
    LiveData<List<L_AnglesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM L_AnglesRivets")
    void deleteAll();

    @Query("SELECT * FROM L_AnglesRivets WHERE rivet_id =:id" )
    ListenableFuture<L_AnglesRivets> getL_AnglesRivetsById(int id);

}
