package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.T_AnglesRivets;

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
    LiveData<List<T_AnglesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM T_AnglesRivets ORDER BY rivet_id DESC")
    LiveData<List<T_AnglesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM T_AnglesRivets")
    void deleteAll();

}
