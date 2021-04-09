package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.L_AnglesRivetsDefects;

import java.util.List;

@Dao
public interface L_AnglesRivetsDefectsDao {

    @Insert
    void insert(L_AnglesRivetsDefects l_AnglesRivetsDefects);

    @Update
    void update(L_AnglesRivetsDefects l_AnglesRivetsDefects);

    @Delete
    void delete(L_AnglesRivetsDefects l_AnglesRivetsDefects);

    @Query("DELETE FROM L_AnglesRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM L_AnglesRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<L_AnglesRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM L_AnglesRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<L_AnglesRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM L_AnglesRivetsDefects")
    void deleteAll();
}
