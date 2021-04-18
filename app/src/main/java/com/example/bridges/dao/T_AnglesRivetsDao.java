package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.T_AnglesRivets;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface T_AnglesRivetsDao {

    @Insert
    void insert(T_AnglesRivets t_AnglesRivets);

    @Update
    void update(T_AnglesRivets t_AnglesRivets);

    @Delete
    void delete(T_AnglesRivets t_AnglesRivets);

    @Query("DELETE FROM T_AnglesRivets WHERE t_angle_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM T_AnglesRivets WHERE t_angle_id = :parentKey ORDER BY rivet_id DESC")
    ListenableFuture<List<T_AnglesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM T_AnglesRivets ORDER BY rivet_id DESC")
    LiveData<List<T_AnglesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM T_AnglesRivets")
    void deleteAll();

    @Query("SELECT * FROM T_AnglesRivets WHERE rivet_id =:id" )
    ListenableFuture<T_AnglesRivets> getT_AnglesRivetsById(int id);


}
