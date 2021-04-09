package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.StiffenerDefects;

import java.util.List;

@Dao
public interface StiffenerDefectsDao {

    @Insert
    void insert(StiffenerDefects stiffenerDefects);

    @Update
    void update(StiffenerDefects stiffenerDefects);

    @Delete
    void delete(StiffenerDefects stiffenerDefects);

    @Query("DELETE FROM StiffenerDefects WHERE stiffener_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM StiffenerDefects WHERE stiffener_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<StiffenerDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM StiffenerDefects ORDER BY defect_id DESC")
    LiveData<List<StiffenerDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM StiffenerDefects")
    void deleteAll();


}
