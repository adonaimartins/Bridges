package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.BackToBackL_AnglesRivets;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface BackToBackL_AnglesRivetsDao {


    @Insert
    void insert(BackToBackL_AnglesRivets backToBackL_AnglesRivets);

    @Update
    void update(BackToBackL_AnglesRivets backToBackL_AnglesRivets);

    @Delete
    void delete(BackToBackL_AnglesRivets backToBackL_AnglesRivets);

    @Query("DELETE FROM BackToBackL_Angles WHERE b2b_l_angle_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM BackToBackL_AnglesRivets WHERE b2b_l_angle_id = :parentKey ORDER BY rivet_id DESC")
    ListenableFuture<List<BackToBackL_AnglesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM BackToBackL_AnglesRivets ORDER BY rivet_id DESC")
    LiveData<List<BackToBackL_AnglesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM BackToBackL_AnglesRivets")
    void deleteAll();

    @Query("SELECT * FROM BackToBackL_AnglesRivets WHERE rivet_id =:id" )
    ListenableFuture<BackToBackL_AnglesRivets> getBackToBackL_AnglesRivetsById(int id);

}
