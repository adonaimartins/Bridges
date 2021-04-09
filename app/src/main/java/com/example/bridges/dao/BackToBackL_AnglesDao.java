package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.BackToBackL_Angles;

import java.util.List;

@Dao
public interface BackToBackL_AnglesDao {

    @Insert
    void insert(BackToBackL_Angles backToBackL_Angles);

    @Update
    void update(BackToBackL_Angles backToBackL_Angles);

    @Delete
    void delete(BackToBackL_Angles backToBackL_Angles);

    @Query("DELETE FROM BackToBackL_Angles WHERE stiffener_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM BackToBackL_Angles WHERE stiffener_id = :parentKey ORDER BY b2b_l_angle_id DESC")
    LiveData<List<BackToBackL_Angles>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM BackToBackL_Angles ORDER BY b2b_l_angle_id DESC")
    LiveData<List<BackToBackL_Angles>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM BackToBackL_Angles")
    void deleteAll();
}
