package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.BackToBackL_AnglesRivetsDefects;

import java.util.List;

@Dao
public interface BackToBackL_AnglesRivetsDefectsDao {





    @Insert
    void insert(BackToBackL_AnglesRivetsDefects backToBackL_AnglesRivetsDefects);

    @Update
    void update(BackToBackL_AnglesRivetsDefects backToBackL_AnglesRivetsDefects);

    @Delete
    void delete(BackToBackL_AnglesRivetsDefects backToBackL_AnglesRivetsDefects);

    @Query("DELETE FROM BackToBackL_AnglesRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM BackToBackL_AnglesRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<BackToBackL_AnglesRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM BackToBackL_AnglesRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<BackToBackL_AnglesRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM BackToBackL_AnglesRivetsDefects")
    void deleteAll();
}
