package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.T_AnglesRivetsDefects;

import java.util.List;

@Dao
public interface T_AnglesRivetsDefectsDao {

    @Insert
    void insert(T_AnglesRivetsDefects t_AnglesRivetsDefects);

    @Update
    void update(T_AnglesRivetsDefects t_AnglesRivetsDefects);

    @Delete
    void delete(T_AnglesRivetsDefects t_AnglesRivetsDefects);

    @Query("DELETE FROM T_AnglesRivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM T_AnglesRivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<T_AnglesRivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM T_AnglesRivetsDefects ORDER BY defect_id DESC")
    LiveData<List<T_AnglesRivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM T_AnglesRivetsDefects")
    void deleteAll();

}
